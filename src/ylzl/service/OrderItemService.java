package ylzl.service;


import ylzl.domain.OrderItem;
import ylzl.dto.OrderItemDTO;

import java.util.List;

public interface OrderItemService {
    /**
     *将订单详情插入OrderItem表中
     * @param orderItem
     */
    public void insert(OrderItem orderItem);

    /**
     * 通过订单号以及商品编号查询订单项信息
     * @param orderId
     * @param productId
     * @return
     */
    public List<OrderItem> getByOrderIdAndProductId(String orderId, String productId);

    /**
     * 通过orderId查询订单项
     * @param id
     * @return
     */
    public OrderItem getById(String id);

    /**
     * 通过orderId查询所有订单项
     * @param orderId
     * @return
     */
    public List<OrderItem> selectAllById(String orderId);

    public List<OrderItemDTO> getOrderItemByOderId(String orderId,int userId);
}
