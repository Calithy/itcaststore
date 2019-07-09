package ylzl.service.impl;

import ylzl.dao.ProductDao;
import ylzl.dao.impl.ProductDaoImpl;
import ylzl.domain.Product;
import ylzl.service.ProductService;

import java.util.List;

/**
 * @program: itcaststore
 * @description: ProductService实现类
 * @author: Leo
 * @create: 2019-07-09 14:45
 **/
public class ProductServiceImpl implements ProductService {
    private ProductDao productDao = new ProductDaoImpl();
    @Override
    public List<Product> listAllProducts() {
        return productDao.selectAll();
    }
}