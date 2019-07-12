package ylzl.web.servlet.manager;

import ylzl.service.OrderService;
import ylzl.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: itcaststore
 * @description: 删除订单Servlet
 * @author: Leo
 * @create: 2019-07-12 14:24
 **/
@WebServlet(name = "deleteOrder", urlPatterns = {"/deleteOrder"})
public class DeleteOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        OrderService orderService = new OrderServiceImpl();
        int delete = orderService.delOrderById(id);
        //删除失败
        if (delete <= 0){
            //放入错误信息
            req.setAttribute("message","删除订单失败");
            req.getRequestDispatcher("/admin/OrderManage.jsp").forward(req,resp);
        }
        //删除成功
        else {
            //重定向得到列表页
            resp.sendRedirect(req.getContextPath() + "/listOrder");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}