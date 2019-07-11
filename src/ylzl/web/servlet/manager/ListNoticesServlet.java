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
import java.util.List;

/**
 * @program: itcaststore
 * @description: 展示所有公告信息
 * @author: Leo
 * @create: 2019-07-11 10:29
 **/
@WebServlet(name = "listNotices", urlPatterns = {"/listNotices"})
public class ListNoticesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NoticeService noticeService = new NoticeServiceImpl();
        List<Notice> notices = noticeService.listAllNotices();
        req.setAttribute("notices",notices);
        req.getRequestDispatcher("/admin/noticeManage.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}