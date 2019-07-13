package ylzl.web.servlet.client;

import ylzl.dao.OrderItemDao;
import ylzl.dao.impl.OrderItemDaoImpl;
import ylzl.domain.Order;
import ylzl.domain.User;
import ylzl.dto.OrderItemDTO;
import ylzl.service.OrderService;
import ylzl.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FindOrderByIdServlet",
            urlPatterns = "/FindOrderByIdServlet")
public class FindOrderByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");//获得订单的当前状态
        String orderid = request.getParameter("orderid");
        User user = (User)request.getSession().getAttribute("user");
        OrderItemDao orderItemDao = new OrderItemDaoImpl();
        List<OrderItemDTO> orderItemDTOList = orderItemDao.selectOrderItemById(orderid,user.getId());
        request.setAttribute("orderItems",orderItemDTOList);
        OrderService orderService = new OrderServiceImpl();
        Order order = orderService.getOrderById(orderid);
        request.setAttribute("orderMoney",order.getMoney());
        int state = 0;
        if(!type.isEmpty()){
            state = Integer.parseInt(type); //支付状态
        }
        if(state == 1){
           // F:\itcaststore\web\paidOrder.jsp
            request.getRequestDispatcher("paidOrder.jsp").forward(request,response);
        }else{
            request.getRequestDispatcher("order.jsp").forward(request,response);
        }
    }
}
