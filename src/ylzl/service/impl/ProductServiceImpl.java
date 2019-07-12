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
    public List<Product> findAllProductBynameWithPage(int pageNum, int pageSize,String f_name) {
        List<Product> productList = productDao.findByStr(f_name);
        int totalRecord = productList.size(); //总的记录条数
        PageBean pageBean = new PageBean(pageNum, pageSize, totalRecord);

        int startIndex = pageBean.getStartIndex();

        productList = productDao.findBynameAndIndexRange(startIndex, pageSize, f_name);
        pageBean.setList(productList);
        return productList;
    }

    @Override
    public List<Product> findProductByCategoryWithPage(int pageNum, int pageSize, String category) {
        List<Product> productList = productDao.findByCategory(category);
        int totalRecord = productList.size(); //某一类别的书籍的总数量
        PageBean pageBean = new PageBean(pageNum,pageSize,totalRecord);

        int startIndex = pageBean.getStartIndex(); //当前索引

        productList = productDao.findByCategoryWithPage(category,startIndex,pageSize);
        pageBean.setList(productList);
        return productList;
    }

    @Override
    public List<Product> listProductWithPage(int pageNum, int pageSize) {
        List<Product> productList = listAllProducts();
        int totalRecord = productList.size(); //某一类别的书籍的总数量
        PageBean pageBean = new PageBean(pageNum,pageSize,totalRecord);

        int startIndex = pageBean.getStartIndex(); //当前索引

        productList = productDao.findProductsWithPage(startIndex,pageSize);
        pageBean.setList(productList);
        return productList;
    }
    @Override
    public List<String> listAllIds() {
        return productDao.getAllIds();
    }

    @Override
    public int update(Product product) {
        return productDao.update(product);
    }

    @Override
    public List<Product> selectByConditions(String id, String name, String category, int minPrice, int maxPrice) {
        return productDao.selectByConditions(id, name, category, minPrice, maxPrice);
    }
}