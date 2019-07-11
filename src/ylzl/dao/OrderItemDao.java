package ylzl.dao;

import ylzl.domain.OrderItem;

import java.util.List;

/**
 * @program: itcaststore
 * @description: 商品项dao
 * @author: Leo
 * @create: 2019-07-09 10:55
 **/
public interface OrderItemDao extends BaseDao<OrderItem> {
    /**
     * 通过order_id查询商品项
     * @param orderId 订单ID
     * @return
     */
    public OrderItem getByOrderId(String orderId);

    /**
     * 通过product_id查询商品项
     * @param productId 商品ID
     * @return
     */
    public List<OrderItem> getByProductId(String productId);

    /**
     * 删除商品项信息
     * @param id ID
     * @return
     */
    public int delete(String id);
}