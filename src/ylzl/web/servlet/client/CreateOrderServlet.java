package ylzl.web.servlet.client;

import org.apache.commons.beanutils.BeanUtils;
import ylzl.domain.Order;
import ylzl.domain.OrderItem;
import ylzl.domain.Product;
import ylzl.domain.User;
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
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

@WebServlet(name = "CreateOrderServlet",
            urlPatterns = "/CreateOrderServlet")
public class CreateOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Map<Product,Integer> cart =  (Map<Product, Integer>) session.getAttribute("cart");
        Order order = new Order();
        try {
            BeanUtils.populate(order,cart); //如果order与cart中有一样的属性，该方法会自动赋值
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        order.setId(UUID.randomUUID().toString()); //生成订单编号
        order.setUser_id(user.getId());
        Iterator iter = cart.keySet().iterator();
        OrderItemService orderItemService = new OrderItemServiceImpl();
        while (iter.hasNext()){
            Product product = (Product) iter.next();
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder_id(order.getId());
            orderItem.setBuynum(cart.get(product));
            orderItem.setProduct_id(product.getId());
            order.getOrderItemList().add(orderItem);
            orderItemService.insert(orderItem);
        }

        OrderService orderService = new OrderServiceImpl();
        orderService.insert(order);

        /**
         * 跳转到订单创建成功页面
         */

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
