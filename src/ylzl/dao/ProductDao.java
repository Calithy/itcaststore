package ylzl.dao;

import ylzl.domain.Product;

import java.util.List;

/**
 * @program: itcaststore
 * @description: 商品dao
 * @author: Leo
 * @create: 2019-07-09 10:32
 **/
public interface ProductDao extends BaseDao<Product>{
    /**
     * 通过id查询商品信息
     * @param id ID String类型
     * @return
     */
    public Product getById(String id);

    /**
     * 通过id删除商品信息
     * @param id ID String类型
     * @return
     */
    public int delete(String id);

    /**
     * 根据str模糊查询商品
     * @param str
     * @return
     */
    public List<Product> findByStr(String str);
}