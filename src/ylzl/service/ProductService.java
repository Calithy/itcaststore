package ylzl.service;

import ylzl.domain.Product;

import java.util.List;

/**
 * @program: itcaststore
 * @description: 商品Service
 * @author: Leo
 * @create: 2019-07-09 14:42
 **/
public interface ProductService {
    /**
     * 查询出所有商品信息 封装成list
     * @return
     */
    public List<Product> listAllProducts();

    /**
     * 插入一条商品信息
     * @param product
     * @return
     */
    public int insert(Product product);

    /**
     * 通过ID查询商品信息
     * @param id
     * @return
     */
    public Product getProductById(String id);

    /**
     * 获取所有商品分类
     * @return
     */
    public List<String> getProductCategory();

    /**
     * 删除一条商品信息
     * @param id
     * @return
     */
    public int delete(String id);
}