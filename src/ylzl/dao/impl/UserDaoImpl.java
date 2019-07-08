package ylzl.dao.impl;

import ylzl.dao.UserDao;
import ylzl.domain.User;

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
        return null;
    }

    @Override
    public User getById(int id) {
        return null;
    }

    @Override
    public List<User> selectAll() {
        return null;
    }

    @Override
    public int insert(User entity) {
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public int update(User entity) {
        return 0;
    }
}