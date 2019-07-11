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

/**
 * @program: itcaststore
 * @description: 编辑公告
 * @author: Leo
 * @create: 2019-07-11 16:35
 **/
@WebServlet(name = "editNotice", urlPatterns = {"/editNotice"})
public class EditNoticeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        NoticeService noticeService = new NoticeServiceImpl();
        Notice notice = noticeService.getById(id);
        req.setAttribute("notice",notice);
        req.getRequestDispatcher("/admin/editNotice.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}