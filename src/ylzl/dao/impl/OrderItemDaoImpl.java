package ylzl.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import ylzl.dao.OrderItemDao;
import ylzl.domain.OrderItem;
import ylzl.dto.OrderItemDTO;
import ylzl.utils.C3P0Utils;

import java.sql.SQLException;
import java.util.List;

/**
 * @program: itcaststore
 * @description: OrderItemDao实现类
 * @author: Leo
 * @create: 2019-07-09 10:59
 **/
public class OrderItemDaoImpl implements OrderItemDao {
    @Override
    public OrderItem getByOrderId(String orderId) {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select * from orderitem where order_id = ?";
        OrderItem orderItem = null;
        try {
            orderItem = qr.query(sql, new BeanHandler<OrderItem>(OrderItem.class), orderId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderItem;
    }

    @Override
    public List<OrderItem> getByProductId(String productId) {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select * from orderitem where product_id = ?";
        List<OrderItem> orderItems = null;
        try {
            orderItems = qr.query(sql, new BeanListHandler<OrderItem>(OrderItem.class), productId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderItems;
    }


    @Override
    public OrderItem getById(int id) {
        //不应调用此方法
        return null;
    }

    @Override
    public List<OrderItem> selectAll() {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select * from orderitem";
        List<OrderItem> orderItems = null;
        try {
            orderItems = qr.query(sql, new BeanListHandler<OrderItem>(OrderItem.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderItems;
    }

    @Override
    public int insert(OrderItem entity) {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "insert into orderitem (order_id, product_id, buynum)" +
                " values (?,?,?)";
        int row = 0;
        try {
            row = qr.update(sql,entity.getOrder_id(), entity.getProduct_id(), entity.getBuynum());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public int delete(int id) {
        //不用调用此方法
        return -1;
    }

    @Override
    public int delete(String id) {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "delete from orderitem where order_id = ?";
        int row = 0;
        try {
            row = qr.update(sql, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public List<OrderItem> getByOrderIdAndProductId(String orderId, String productId) {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select order_id,product_id,buynum from orderitem where order_id = ? and product_id = ?";
        List<OrderItem> orderItems = null;
        try {
            orderItems = qr.query(sql, new BeanListHandler<OrderItem>(OrderItem.class),orderId,productId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderItems;
    }

    @Override
    public List<OrderItem> selectOrdersById(String orderId) {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select order_id,product_id,buynum from orderitem where order_id = ?";
        List<OrderItem> orderItems = null;
        try {
            orderItems = qr.query(sql, new BeanListHandler<OrderItem>(OrderItem.class),orderId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderItems;
    }

    @Override
    public List<OrderItemDTO> selectOrderItemById(String orderId,int userId) {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select o.receiverAddress,o.receiverName,o.receiverPhone,o.paystate,o.ordertime,o.user_id,p.`name`,p.price,orderitem.buynum " +
                "from  products as p JOIN orderitem  ON orderitem.product_id = p.id" +
                " JOIN orders as o on o.id = orderitem.order_id " +
                "WHERE o.user_id = ? " +
                "AND orderitem.order_id = ?";
        List<OrderItemDTO> orderItemDTOList = null;
        try {
            orderItemDTOList = qr.query(sql,new BeanListHandler<OrderItemDTO>(OrderItemDTO.class),userId,orderId);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderItemDTOList;

    }

    @Override
    public int update(OrderItem entity) {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "update orderitem set buynum=? where order_id = ?";
        int row = 0;
        try {
            row = qr.update(sql,entity.getBuynum(),entity.getOrder_id());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }
}