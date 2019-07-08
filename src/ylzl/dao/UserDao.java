package ylzl.dao;

import ylzl.domain.User;

/**
 * @program: itcaststore
 * @description: 用户dao
 * @author: Leo
 * @create: 2019-07-08 20:42
 **/
public interface UserDao extends BaseDao<User>{
    /**
     * 通过用户名查询用户信息
     * @param username 用户名
     * @return
     */
    public User getByUsername(String username);
}