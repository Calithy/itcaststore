package ylzl.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import ylzl.dao.UserDao;
import ylzl.domain.User;
import ylzl.utils.C3P0Utils;

import java.sql.SQLException;
import java.util.List;

/**
 * @program: itcaststore
 * @description: 用户dao实现类
 * @author: Leo
 * @create: 2019-07-08 20:52
 **/
public class UserDaoImpl implements UserDao {
    @Override
    public User getByUsername(String username) {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select * from user where username = ?";
        User user = null;
        try {
            user = qr.query(sql, new BeanHandler<User>(User.class), username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User getById(int id) {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select * from user where id = ?";
        User user = null;
        try {
            user = qr.query(sql, new BeanHandler<User>(User.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> selectAll() {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select * from user";
        List<User> users = null;
        try {
            users = qr.query(sql, new BeanListHandler<User>(User.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public int insert(User entity) {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "insert into user (username,password,gender,email,telephone,introduce,activeCode,state,role,registTime)" +
                " values (?,?,?,?,?,?,?,?,?,?)";
        int row = 0;
        try {
            row = qr.update(sql,entity.getUsername(),entity.getPassword(),entity.getGender(),entity.getEmail(),
                    entity.getTelphone(),entity.getIntroduce(),entity.getActiveCode(),entity.getState(),entity.getRole(),entity.getRegistTime());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public int delete(int id) {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "delete from user where id = ?";
        int row = 0;
        try {
            row = qr.update(sql, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public int update(User entity) {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "update user set username=?,password=?,gender=?,email=?,telephone=?,introduce=?,activeCode=?,state=?,role=?,registTime=? where id = ?";
        int row = 0;
        try {
            row = qr.update(sql,entity.getUsername(),entity.getPassword(),entity.getGender(),entity.getEmail(),
                    entity.getTelphone(),entity.getIntroduce(),entity.getActiveCode(),entity.getState(),entity.getRole(),entity.getRegistTime(),entity.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }
}