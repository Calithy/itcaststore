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

}