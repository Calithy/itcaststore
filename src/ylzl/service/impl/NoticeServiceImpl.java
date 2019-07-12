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
}