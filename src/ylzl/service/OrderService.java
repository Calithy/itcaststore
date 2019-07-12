package ylzl.service;

import ylzl.domain.Order;
import ylzl.dto.OrderDTO;

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
    /**
     * 将新订单插入表中
     * @param order
     */
    public int insert(Order order);

    /**
     * 根据订单编号查询订单
     * @param id
     */
    public Order getOrderById(String id);

    /**
     * 根据id删除订单
     * @param id
     */
    public int delOrderById(String id);

    /**
     * 查询所有订单信息（包含用户信息）
     * @return
     */
    public List<OrderDTO> listAllOrdersWithUserInfo();
}
