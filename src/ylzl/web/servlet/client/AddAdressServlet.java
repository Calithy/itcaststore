package ylzl.web.servlet.client;

import ylzl.domain.Order;
import ylzl.service.OrderService;
import ylzl.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name = "AddAdressServlet",
            urlPatterns = "/AddAdressServlet")
public class AddAdressServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String address = req.getParameter("address");
        String username = req.getParameter("username");
        String orderId = req.getParameter("orderId");
        String telphone = req.getParameter("telphone");
        String money = req.getParameter("money");
        System.out.println(address + username + orderId + telphone + money);
        OrderService orderService = new OrderServiceImpl();
        Order order = orderService.getOrderById(orderId);
        order.setReceiverAddress(address);
        order.setReceiverName(username);
        order.setReceiverPhone(telphone);
        order.setMoney(Double.parseDouble(money));
        int row = orderService.update(order);
        //resp.sendRedirect(req.getContextPath() + "/FindOrderByUserServlet");
        resp.setHeader("redirectUrl",req.getContextPath() + "/FindOrderByUserServlet");
        resp.setHeader("enableRedirect","true");
    }
}
