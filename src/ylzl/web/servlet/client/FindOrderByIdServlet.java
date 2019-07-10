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

@WebServlet(name = "FindOrderByIdServlet",
            urlPatterns = "/FindOrderByIdServlet")
public class FindOrderByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");//获得订单的当前状态
        String orderid = request.getParameter("orderid");

        OrderService orderService = new OrderServiceImpl();
        Order order = orderService.getOrderById(orderid);
        boolean state = false;
        if(!type.isEmpty()){
            state = Boolean.parseBoolean(type); //支付状态
        }
        if(state){
            request.getRequestDispatcher("查看页面").forward(request,response);
        }else{
            request.getRequestDispatcher("支付页面").forward(request,response);
        }
    }
}
