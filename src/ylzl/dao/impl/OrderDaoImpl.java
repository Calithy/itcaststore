package ylzl.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import ylzl.dao.OrderDao;
import ylzl.domain.Notice;
import ylzl.domain.Order;
import ylzl.utils.C3P0Utils;

import java.sql.SQLException;
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
            row = qr.update(sql,entity.getId(),entity.getMoeny(),entity.getReceiverAddress(),entity.getReceiverName(),entity.getReceiverPhone(),
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
            row = qr.update(sql,entity.getMoeny(),entity.getReceiverAddress(),entity.getReceiverName(),entity.getReceiverPhone(),
                    entity.getPaystate(),entity.getOrdertime(),entity.getUser_id(),entity.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }
}