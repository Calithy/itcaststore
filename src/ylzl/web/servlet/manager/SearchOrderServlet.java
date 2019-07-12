package ylzl.web.servlet.manager;

import ylzl.dto.OrderDTO;
import ylzl.service.OrderService;
import ylzl.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @program: itcaststore
 * @description: 查询订单信息Servlet
 * @author: Leo
 * @create: 2019-07-12 15:30
 **/
@WebServlet(name = "searchOrder", urlPatterns = {"/searchOrder"})
public class SearchOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderService orderService = new OrderServiceImpl();
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        List<OrderDTO> orderDTOS = null;
        //所有条件都为空 -> 查询所有
        if ((id == null || id.trim().length() <= 0) &&
                (name == null || name.trim().length() <= 0)){
            resp.sendRedirect(req.getContextPath() + "/listOrder");
        }
        else {
            //通过条件查询订单信息
            orderDTOS = orderService.selectByConditions(id, name);
            req.setAttribute("orders",orderDTOS);
            req.getRequestDispatcher("/admin/orderManage.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}