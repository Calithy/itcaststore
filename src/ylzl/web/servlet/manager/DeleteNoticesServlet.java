package ylzl.web.servlet.manager;

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
 * @description: 删除公告
 * @author: Leo
 * @create: 2019-07-12 17:27
 **/
@WebServlet(name = "deleteNotice", urlPatterns = {"/deleteNotice"})
public class DeleteNoticesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        NoticeService noticeService = new NoticeServiceImpl();
        int delete = noticeService.delete(id);
        if (delete <= 0){
            req.setAttribute("message","删除公告失败");
            req.getRequestDispatcher("/admin/noticeManage.jsp").forward(req,resp);
        }
        else {
            resp.sendRedirect(req.getContextPath() + "/listNotices");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}