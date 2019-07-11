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
 * @description: 展示所有订单信息
 * @author: Leo
 * @create: 2019-07-10 09:07
 **/
@WebServlet(name = "listOrder", urlPatterns = {"/listOrder"})
public class ListOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderService orderService = new OrderServiceImpl();
        List<OrderDTO> orderDTOS = orderService.listAllOrdersWithUserInfo();
        req.setAttribute("orders",orderDTOS);
        System.out.println(orderDTOS);
        req.getRequestDispatcher("/admin/orderManage.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}