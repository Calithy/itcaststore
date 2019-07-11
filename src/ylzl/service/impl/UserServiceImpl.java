package ylzl.service.impl;

import ylzl.dao.UserDao;
import ylzl.dao.impl.UserDaoImpl;
import ylzl.domain.User;
import ylzl.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public User findUserByUsername(String u_name) {
        return userDao.getByUsername(u_name);
    }

    @Override
    public User findUserById(int id) {
        return userDao.getById(id);
    }

    @Override
    public int insert(User user) {
        int row = userDao.insert(user);
        return  row;
    }

    @Override
    public int update(User user) {
        return userDao.update(user);
    }
}
