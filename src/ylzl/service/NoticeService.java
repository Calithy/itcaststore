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
}