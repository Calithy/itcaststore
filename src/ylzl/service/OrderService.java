package ylzl.service;

import ylzl.domain.Order;

public interface OrderService {
    /**
     * 将新订单插入表中
     * @param order
     */
    public void insert(Order order);
}
