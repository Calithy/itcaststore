package ylzl.service;

import ylzl.domain.User;

public interface UserService {

    /**
     *根据用户名查询用户
     * @param u_name
     * @return
     */
    public User findUserByUsername(String u_name);

    /**
     * 根据用户Id查询用户
     * @param id
     * @return
     */
    public User findUserById(int id);

    /**
     * 插入User表
     * @param user
     */
    public int insert(User user);

    /**
     * 更新User信息
     * @return
     */
    public  int update(User user);
}

