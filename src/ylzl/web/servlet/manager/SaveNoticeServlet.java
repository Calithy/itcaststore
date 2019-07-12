package ylzl.web.servlet.manager;

import ylzl.domain.Notice;
import ylzl.service.NoticeService;
import ylzl.service.impl.NoticeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @program: itcaststore
 * @description: 保存公告信息
 * @author: Leo
 * @create: 2019-07-12 09:57
 **/
@WebServlet(name = "saveNotice", urlPatterns = {"/saveNotice"})
public class SaveNoticeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NoticeService noticeService = new NoticeServiceImpl();
        String id = req.getParameter("id");
        Notice notice = new Notice();
        boolean add = false;
        //ID为空 添加
        if (id == null || id.trim().length() <= 0){
            add = true;
        }
        //修改
        else {
            notice.setN_id(Integer.parseInt(id));
        }
        notice.setTitle(req.getParameter("title"));
        notice.setDetails(req.getParameter("details"));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formatedDate = simpleDateFormat.format(new Date());
        notice.setN_time(formatedDate);
        if (add){
            int insert = noticeService.insert(notice);
            if (insert <= 0){
                req.setAttribute("message","添加公告失败");
                req.getRequestDispatcher("/admin/editNotice.jsp").forward(req,resp);
            }
        }
        else {
            int update = noticeService.update(notice);
            if (update <= 0){
                //放入错误提示信息
                req.setAttribute("message","修改公告失败");
                req.getRequestDispatcher("/admin/editNotice.jsp").forward(req,resp);
            }
        }
        //重定向到列表页
        resp.sendRedirect(req.getContextPath() + "/listNotices");
    }
}