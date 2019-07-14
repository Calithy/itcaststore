package ylzl.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import ylzl.dao.OrderDao;
import ylzl.domain.Order;
import ylzl.dto.OrderDTO;
import ylzl.utils.C3P0Utils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: itcaststore
 * @description: OrderDao实现类
 * @author: Leo
 * @create: 2019-07-09 09:58
 **/
public class OrderDaoImpl implements OrderDao {
    @Override
    public List<Order> getByUserId(int userId) {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select * from orders where user_id = ?";
        List<Order> orders = null;
        try {
            orders = qr.query(sql, new BeanListHandler<Order>(Order.class), userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public Order getById(String id) {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select * from orders where id = ?";
        Order order = null;
        try {
            order = qr.query(sql, new BeanHandler<Order>(Order.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public Order getById(int id) {
        //不应调用此方法
        return null;
    }

    @Override
    public List<Order> selectAll() {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select * from orders";
        List<Order> orders = null;
        try {
            orders = qr.query(sql, new BeanListHandler<Order>(Order.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public int insert(Order entity) {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "insert into orders (id,money,receiverAddress,receiverName,receiverPhone,paystate,ordertime,user_id)" +
                " values (?,?,?,?,?,?,?,?)";
        int row = 0;
        try {
            row = qr.update(sql,entity.getId(),entity.getMoney(),entity.getReceiverAddress(),entity.getReceiverName(),entity.getReceiverPhone(),
                    entity.getPaystate(),entity.getOrdertime(),entity.getUser_id());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public int delete(String id) {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "delete from orders where id = ?";
        int row = 0;
        try {
            row = qr.update(sql, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public List<OrderDTO> selectAllOrdersWithUserInfo() {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select o.id,o.money,o.receiverAddress,o.receiverName,o.receiverPhone,o.ordertime,o.paystate,u.username as userName,u.id as userId" +
                " from orders as o left join user as u on o.user_id = u.id";
        List<OrderDTO> orderDTOS = null;
        try {
            orderDTOS = qr.query(sql, new BeanListHandler<OrderDTO>(OrderDTO.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderDTOS;
    }

    @Override
    public OrderDTO getOrderByIdWithUserInfo(String id) {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select o.id,o.money,o.receiverAddress,o.receiverName,o.receiverPhone,o.ordertime,o.paystate,u.username as userName,u.id as userId" +
                " from orders as o left join user as u on o.user_id = u.id where o.id = ?";
        OrderDTO orderDTO = null;
        try {
            orderDTO = qr.query(sql, new BeanHandler<>(OrderDTO.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderDTO;
    }

    @Override

    public List<OrderDTO> selectByConditions(String id, String name) {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select o.id,o.money,o.receiverAddress,o.receiverName,o.receiverPhone,o.ordertime,o.paystate,u.username as userName,u.id as userId" +
                " from orders as o left join user as u on o.user_id = u.id where ";
        StringBuilder condition = new StringBuilder();
        List<Object> params = new ArrayList<>();
        //是否是第一个参数（用于sql拼接）
        boolean first = true;
        //id不为空
        if (id != null && id.trim().length() > 0){
            condition.append("o.id = ? ");
            params.add(id);
            first = false;
        }
        //name不为空
        if (name != null && name.trim().length() > 0){
            if (first){
                condition.append("o.receiverName = ? ");
            }
            else {
                condition.append("and o.receiverName = ? ");
            }
            params.add(name);
        }
        sql += condition.toString();
        List<OrderDTO> orderDTOS = null;
        try {
            orderDTOS = qr.query(sql, new BeanListHandler<OrderDTO>(OrderDTO.class),params.toArray());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderDTOS;
    }



    @Override
    public int delete(int id) {
        //不应调用此方法
        return -1;
    }

    @Override
    public int update(Order entity) {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "update orders set money=?, receiverAddress=?, receiverName=?, receiverPhone=?, paystate=?,ordertime=?,user_id=?  where id = ?";
        int row = 0;
        try {
            row = qr.update(sql,entity.getMoney(),entity.getReceiverAddress(),entity.getReceiverName(),entity.getReceiverPhone(),
                    entity.getPaystate(),entity.getOrdertime(),entity.getUser_id(),entity.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }
}