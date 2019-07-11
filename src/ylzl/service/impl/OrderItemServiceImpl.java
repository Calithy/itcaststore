package ylzl.service.impl;

import ylzl.dao.OrderItemDao;
import ylzl.dao.impl.OrderItemDaoImpl;
import ylzl.domain.OrderItem;
import ylzl.service.OrderItemService;

public class OrderItemServiceImpl implements OrderItemService {
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    @Override
    public void insert(OrderItem orderItem) {
        orderItemDao.insert(orderItem);
    }
}
