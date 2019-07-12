package ylzl.service.impl;

import ylzl.dao.OrderItemDao;
import ylzl.dao.impl.OrderItemDaoImpl;
import ylzl.domain.OrderItem;
import ylzl.service.OrderItemService;

import java.util.List;

public class OrderItemServiceImpl implements OrderItemService {
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    @Override
    public void insert(OrderItem orderItem) {
        orderItemDao.insert(orderItem);
    }

    @Override
    public List<OrderItem> getByOrderIdAndProductId(String orderId, String productId) {
        return orderItemDao.getByOrderIdAndProductId(orderId,productId);
    }

    @Override
    public OrderItem getById(String id) {
        return orderItemDao.getByOrderId(id);
    }

    @Override
    public List<OrderItem> selectAllById(String orderId) {
        return orderItemDao.selectOrdersById(orderId);
    }
}
