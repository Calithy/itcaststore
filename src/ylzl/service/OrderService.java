package ylzl.service;

import ylzl.domain.Order;

public interface OrderService {
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
}
