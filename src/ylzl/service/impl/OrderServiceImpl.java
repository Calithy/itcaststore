package ylzl.service.impl;

import ylzl.dao.OrderDao;
import ylzl.dao.impl.OrderDaoImpl;
import ylzl.domain.Order;
import ylzl.dto.OrderDTO;
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

    @Override
    public List<OrderDTO> listAllOrdersWithUserInfo() {
        return orderDao.selectAllOrdersWithUserInfo();
    }

    @Override
    public OrderDTO getOrderByIdWithUserInfo(String id) {
        return orderDao.getOrderByIdWithUserInfo(id);
    }
}
