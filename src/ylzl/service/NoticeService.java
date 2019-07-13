package ylzl.service;

import ylzl.domain.Notice;

import java.util.List;

/**
 * @program: itcaststore
 * @description: 公告Service
 * @author: Leo
 * @create: 2019-07-11 10:32
 **/
public interface NoticeService {
    /**
     * 查询所有公告信息
     * @return
     */
    public List<Notice> listAllNotices();

    /**
     * 通过ID查询公告
     * @param id ID
     * @return
     */
    public Notice getById(String id);

    /**
     * 添加
     * @param notice
     * @return
     */
    public int insert(Notice notice);

    /**
     * 修改
     * @param notice
     * @return
     */
    public int update(Notice notice);

    /**
     * 删除
     * @param id
     * @return
     */
    public int delete(String id);
}