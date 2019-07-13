package ylzl.web.servlet.client;

import ylzl.domain.Order;
import ylzl.domain.User;
import ylzl.service.OrderService;
import ylzl.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FindOrderByUserServlet",
            urlPatterns = "/FindOrderByUserServlet")
public class FindOrderByUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute("user");

        OrderService orderService = new OrderServiceImpl();
        List<Order> orderList = orderService.getOrderByUserId(user.getId());
        request.setAttribute("orders",orderList);
        request.getRequestDispatcher("/orders.jsp").forward(request,response);


    }
}
