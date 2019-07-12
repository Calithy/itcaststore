package ylzl.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import ylzl.dao.ProductDao;
import ylzl.domain.Product;
import ylzl.utils.C3P0Utils;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * @program: itcaststore
 * @description: ProductDao实现类
 * @author: Leo
 * @create: 2019-07-09 10:33
 **/
public class ProductDaoImpl implements ProductDao {
    @Override
    public Product getById(int id) {
        //不应调用此方法
        return null;
    }

    @Override
    public Product getById(String id) {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select * from products where id = ?";
        Product product = null;
        try {
            product = qr.query(sql, new BeanHandler<Product>(Product.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }
    @Override
    public List<Product> selectAll() {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select * from products";
        List<Product> products = null;
        try {
            products = qr.query(sql, new BeanListHandler<Product>(Product.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public int insert(Product entity) {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "insert into products (id,name,price,category,pnum,imgurl,description)" +
                " values (?,?,?,?,?,?,?)";
        int row = 0;
        try {
            row = qr.update(sql,entity.getId(),entity.getName(),entity.getPrice(),entity.getCategory(),entity.getPnum(),
                    entity.getImgurl(),entity.getDescription());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public int delete(String id) {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "delete from products where id = ?";
        int row = 0;
        try {
            row = qr.update(sql, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public int delete(int id) {
        //不应调用此方法
        return -1;
    }

    @Override
    public int update(Product entity) {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "update products set name=?, price=?, category=?, pnum=?, imgurl=?,description=?  where id = ?";
        int row = 0;
        try {
            row = qr.update(sql,entity.getName(),entity.getPrice(),entity.getCategory(),entity.getPnum(),entity.getImgurl(),
                    entity.getDescription(),entity.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public List<Product> findByStr(String str) {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        /*模糊查询不要忘记 ? 两侧的空格*/
        String sql = "select id,name,price,category,pnum,imgurl,description from products where name LIKE '%' ? '%' ";
        List<Product> products = null;
        try {

            products = qr.query(sql, new BeanListHandler<Product>(Product.class),str);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }


    public List<String> getAllCategory() {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select category from products group by category";
        List<String> categories = new ArrayList<>();
        try {
            List<Object[]> query = qr.query(sql,new ArrayListHandler());
            for (Object[] objects : query) {
                if (objects != null && objects.length >= 1){
                    if (objects[0] != null)
                        categories.add(objects[0].toString());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public List<Product> findBynameAndIndexRange(int start, int pagesize,String f_name) {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select id,name,price,category,pnum,imgurl,description from products where name like '%' ? '%' limit ?,?";
        List<Product> productList = null;
        try {
            productList = qr.query(sql, new BeanListHandler<Product>(Product.class), f_name, start, pagesize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public List<Product> findByCategoryWithPage(String category,int startIndex,int pageSize) {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select id,name,price,category,pnum,imgurl,description from products where category = ? limit ?,?";
        List<Product> productList = null;
        try {
            productList = qr.query(sql,new BeanListHandler<Product>(Product.class),category,startIndex,pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public List<Product> findByCategory(String category) {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select id,name,price,category,pnum,imgurl,description from products where category = ?";
        List<Product> productList = null;
        try {
            productList = qr.query(sql,new BeanListHandler<Product>(Product.class),category);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public List<Product> findProductsWithPage(int startIndex, int pageSize) {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select id,name,price,category,pnum,imgurl,description from products limit ?,?";
        List<Product> productList = null;
        try {
            productList = qr.query(sql,new BeanListHandler<Product>(Product.class),startIndex,pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;

    }
    @Override
    public List<String> getAllIds() {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select id from products";
        List<String> ids = new ArrayList<>();
        try {
            List<Object[]> result = qr.query(sql, new ArrayListHandler());
            //将查询出的ID放入list中
            for (Object[] objects : result) {
                if (objects != null && objects.length >= 1){
                    if (objects[0] != null)
                        ids.add(objects[0].toString());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ids;
    }

    @Override
    public List<Product> selectByConditions(String id, String name, String category, int minPrice, int maxPrice) {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select id,name,price,category,pnum,imgurl,description from products where ";
        StringBuilder condition = new StringBuilder();
        List<Object> params = new ArrayList<>();
        //是否是第一个参数（sql拼接）
        boolean first = true;
        //id不为空
        if (id != null && id.trim().length() > 0){
            condition.append("id = ? ");
            params.add(id);
            first = false;
        }
        //name不为空
        if (name != null && name.trim().length() > 0){
            if (first){
                condition.append("name = ?");
                first = false;
            }
            else {
                condition.append("and name = ? ");
            }
            params.add(name);
        }
        //category不为空
        if (category != null && category.trim().length() > 0){
            if (first){
                condition.append("category = ? ");
                first = false;
            }
            else {
                condition.append("and category = ? ");
            }
            params.add(category);
        }
        //minPrice maxPrice合理
        if (minPrice >=0 && maxPrice > 0 && maxPrice >= minPrice){
            if (first){
                condition.append("price between ? and ?");
            }
            else {
                condition.append("and price between ? and ?");
            }
            params.add(minPrice);
            params.add(maxPrice);
        }
        sql += condition.toString();
        List<Product> productList = null;
        try {
            productList = qr.query(sql,new BeanListHandler<Product>(Product.class),params.toArray());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }
}
