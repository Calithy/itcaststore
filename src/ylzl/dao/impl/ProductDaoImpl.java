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
        String sql = "select id,name,price,category,pnum,imgurl,description from products where name LIKE '%?%'";
        List<Product> products = null;
        try {
            products = qr.query(sql, new BeanListHandler<Product>(Product.class), str);
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
    public List<Product> findByIndexRange(int start, int pagesize,String f_name) {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select id,name,price,category,pnum,imgurl,description from products where name like %?% limit ?,?";
        List<Product> productList = null;
        try {
            productList = qr.query(sql, new BeanListHandler<Product>(Product.class), f_name, start, pagesize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }
}