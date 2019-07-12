package ylzl.service;


import ylzl.domain.OrderItem;

public interface OrderItemService {
    /**
     *将订单详情插入OrderItem表中
     * @param orderItem
     */
    public void insert(OrderItem orderItem);
}
