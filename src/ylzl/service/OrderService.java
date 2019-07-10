package ylzl.service;

import ylzl.domain.Order;

import java.util.List;

/**
 * @program: itcaststore
 * @description: 订单Service
 * @author: Leo
 * @create: 2019-07-10 09:09
 **/
public interface OrderService {
    /**
     * 列出所有订单信息
     * @return
     */
    public List<Order> listAllOrders();
}