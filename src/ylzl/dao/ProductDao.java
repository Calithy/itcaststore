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



    /**
     * 查询所有分类
     * @return
     */
    public List<String> getAllCategory();

    /**
     * 根据索引范围以及str模糊查询
     * @param start
     * @param pagesize
     * @param f_name
     * @return
     */
    public  List<Product> findBynameAndIndexRange(int start,int pagesize,String f_name);

    /**
     * 根据商品类别查询商品
     * @param category
     * @return
     */
    public  List<Product> findByCategory(String category);

    /**
     * 根据商品类别分页查询商品
     * @param category
     * @return
     */
    public  List<Product> findByCategoryWithPage(String category,int startIndex,int pageSize);

    /**
     * 分页查询所有商品
     * @param startIndex
     * @param pageSize
     * @return
     */
    public  List<Product> findProductsWithPage(int startIndex,int pageSize);



}