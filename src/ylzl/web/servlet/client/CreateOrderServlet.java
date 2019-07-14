package ylzl.web.servlet.client;

import org.apache.commons.beanutils.BeanUtils;
import ylzl.domain.Order;
import ylzl.domain.OrderItem;
import ylzl.domain.Product;
import ylzl.domain.User;
import ylzl.dto.OrderItemDTO;
import ylzl.service.OrderItemService;
import ylzl.service.OrderService;
import ylzl.service.impl.OrderItemServiceImpl;
import ylzl.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

@WebServlet(name = "CreateOrderServlet",
            urlPatterns = "/CreateOrderServlet")
public class CreateOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Map<Product,Integer> cart =  (Map<Product, Integer>) session.getAttribute("cart");
        Order order = new Order();
        order.setId(UUID.randomUUID().toString()); //生成订单编号
        order.setUser_id(user.getId());
        Iterator iter = cart.keySet().iterator();
        OrderItemService orderItemService = new OrderItemServiceImpl();
        List<OrderItem> orderItemList = new ArrayList<OrderItem>();
        while (iter.hasNext()){
            Product product = (Product) iter.next();
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder_id(order.getId());
            orderItem.setBuynum(cart.get(product));
            orderItem.setProduct_id(product.getId());
            orderItemList.add(orderItem);
            orderItemService.insert(orderItem);
        }
        order.setOrderItemList(orderItemList);

        OrderService orderService = new OrderServiceImpl();
        int row = orderService.insert(order);
        if(row == 0){
            System.out.println("插入数据库失败1111111");
        }else{
            System.out.println("插入成功!123456");
        }
        List<OrderItemDTO> orderItems= orderItemService.getOrderItemByOderId(order.getId(),user.getId());
       //
        OrderItemDTO orderItemDTO = new OrderItemDTO();
        orderItemDTO.setId(order.getId());
        orderItems.add(orderItemDTO);

       // session.setAttribute("orderId",order.getId());
        /**
         * 跳转到订单创建成功页面
         *
         */
        request.setAttribute("orderItems",orderItems);
        request.getRequestDispatcher("checkout.jsp").forward(request,response);
       // response.sendRedirect("createOrderSuccess.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
