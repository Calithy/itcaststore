package ylzl.service.impl;

import ylzl.dao.ProductDao;
import ylzl.dao.impl.ProductDaoImpl;
import ylzl.domain.PageBean;
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

    @Override
    public int insert(Product product) {
        return productDao.insert(product);
    }

    @Override
    public Product getProductById(String id) {
        return productDao.getById(id);
    }

    @Override
    public List<String> getProductCategory() {
        return productDao.getAllCategory();
    }

    @Override
    public int delete(String id) {
        return productDao.delete(id);
    }

    public List<Product> listAllProductsByStr(String str) { return  productDao.findByStr(str); }

    @Override
    public List<Product> findAllProductWithPage(int pageNum, int pageSize,String f_name) {
        List<Product> productList = listAllProducts();
        int totalRecord = productList.size(); //总的记录条数
        PageBean pageBean = new PageBean(pageNum, pageSize, totalRecord);

        int startIndex = pageBean.getStartIndex();

        productList = productDao.findByIndexRange(startIndex, pageSize, f_name);
        pageBean.setList(productList);
        return productList;
    }


}