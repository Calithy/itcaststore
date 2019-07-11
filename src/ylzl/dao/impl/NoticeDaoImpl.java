package ylzl.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import ylzl.dao.NoticeDao;
import ylzl.domain.Notice;
import ylzl.utils.C3P0Utils;

import java.sql.SQLException;
import java.util.List;

/**
 * @program: itcaststore
 * @description: 公告dao实现
 * @author: Leo
 * @create: 2019-07-09 09:15
 **/
public class NoticeDaoImpl implements NoticeDao {
    @Override
    public Notice getById(int id) {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select * from notice where n_id = ?";
        Notice notice = null;
        try {
            notice = qr.query(sql, new BeanHandler<Notice>(Notice.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notice;
    }

    @Override
    public List<Notice> selectAll() {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select * from notice";
        List<Notice> notices = null;
        try {
            notices = qr.query(sql, new BeanListHandler<Notice>(Notice.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notices;
    }

    @Override
    public int insert(Notice entity) {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "insert into notice (title,details,n_time)" +
                " values (?,?,?)";
        int row = 0;
        try {
            row = qr.update(sql,entity.getTitle(),entity.getDetails(),entity.getN_time());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public int delete(int id) {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "delete from notice where n_id = ?";
        int row = 0;
        try {
            row = qr.update(sql, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public int update(Notice entity) {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "update notice set title=?, details=?, n_time=? where n_id = ?";
        int row = 0;
        try {
            row = qr.update(sql,entity.getTitle(),entity.getDetails(),entity.getN_time(),entity.getN_id());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }
}