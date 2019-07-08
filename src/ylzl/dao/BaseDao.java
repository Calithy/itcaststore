package ylzl.dao;

import java.util.List;

/**
 * @program: itcaststore
 * @description: 所有dao接口标准
 * @author: Leo
 * @create: 2019-07-08 20:44
 **/
public interface BaseDao<T> {
    /**
     * 通过ID查询信息
     * @param id ID
     * @return
     */
    public T getById(int id);
    /**
     * 查询所有信息
     * @return
     */
    public List<T> selectAll();

    /**
     * 插入一条记录
     * @param entity 实体对象
     * @return
     */
    public int insert(T entity);

    /**
     * 删除一条记录
     * @param id ID
     * @return
     */
    public int delete(int id);

    /**
     * 更新一条记录
     * @param entity 实体对象
     * @return
     */
    public int update(T entity);
}