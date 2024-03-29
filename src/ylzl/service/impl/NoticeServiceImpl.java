package ylzl.service.impl;

import ylzl.dao.NoticeDao;
import ylzl.dao.impl.NoticeDaoImpl;
import ylzl.domain.Notice;
import ylzl.service.NoticeService;

import java.util.List;

/**
 * @program: itcaststore
 * @description:
 * @author: Leo
 * @create: 2019-07-11 10:33
 **/
public class NoticeServiceImpl implements NoticeService {
    private NoticeDao noticeDao = new NoticeDaoImpl();
    @Override
    public List<Notice> listAllNotices() {
        return noticeDao.selectAll();
    }

    @Override
    public Notice getById(String id) {
        return noticeDao.getById(Integer.parseInt(id));
    }

    @Override
    public int insert(Notice notice) {
        return noticeDao.insert(notice);
    }

    @Override
    public int update(Notice notice) {
        return noticeDao.update(notice);
    }

    @Override
    public int delete(String id) {
        return noticeDao.delete(Integer.parseInt(id));
    }
}