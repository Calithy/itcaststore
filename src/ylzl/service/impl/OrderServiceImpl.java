package ylzl.service.impl;

import ylzl.dao.OrderDao;
import ylzl.dao.impl.OrderDaoImpl;
import ylzl.domain.Order;
import ylzl.service.OrderService;

import java.util.List;

/**
 * @program: itcaststore
 * @description: OrderService实现类
 * @author: Leo
 * @create: 2019-07-10 09:13
 **/
public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    @Override
    public List<Order> listAllOrders() {
        return orderDao.selectAll();
    }
}