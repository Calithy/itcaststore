package ylzl.service.impl;

import ylzl.dao.OrderDao;
import ylzl.dao.impl.OrderDaoImpl;
import ylzl.domain.Order;
import ylzl.service.OrderService;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    @Override
    public int insert(Order order) {
        return orderDao.insert(order);
    }

    @Override
    public Order getOrderById(String id) {
       return orderDao.getById(id);

    }

    @Override
    public int delOrderById(String id) {
       return orderDao.delete(id);
    }
}
