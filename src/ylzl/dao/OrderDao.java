package ylzl.dao;

import ylzl.domain.Order;

import java.util.List;

/**
 * @program: itcaststore
 * @description: 订单dao
 * @author: Leo
 * @create: 2019-07-09 09:56
 **/
public interface OrderDao extends BaseDao<Order> {
    /**
     * 通过用户id查询订单
     * @param userId
     * @return
     */
    public List<Order> getByUserId(int userId);

    /**
     * 通过Id查询 id为String类型
     * @param id
     * @return
     */
    public Order getById(String id);

    /**
     * 删除订单信息
     * @param id
     * @return
     */
    public int delete(String id);
}