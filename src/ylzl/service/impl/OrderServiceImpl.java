package ylzl.service.impl;

import ylzl.dao.OrderDao;
import ylzl.dao.impl.OrderDaoImpl;
import ylzl.domain.Order;
import ylzl.service.OrderService;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    @Override
    public void insert(Order order) {
        orderDao.insert(order);
    }
}
