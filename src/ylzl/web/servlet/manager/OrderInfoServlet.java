package ylzl.web.servlet.manager;

import ylzl.domain.Order;
import ylzl.domain.OrderItem;
import ylzl.domain.Product;
import ylzl.dto.OrderDTO;
import ylzl.service.OrderItemService;
import ylzl.service.OrderService;
import ylzl.service.ProductService;
import ylzl.service.UserService;
import ylzl.service.impl.OrderItemServiceImpl;
import ylzl.service.impl.OrderServiceImpl;
import ylzl.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: itcaststore
 * @description: 订单详情Servlet
 * @author: Leo
 * @create: 2019-07-12 10:48
 **/
@WebServlet(name = "orderInfo", urlPatterns = {"/orderInfo"})
public class OrderInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderService orderService = new OrderServiceImpl();
        //查询订单信息（包含用户信息）
        OrderDTO orderDTO = orderService.getOrderByIdWithUserInfo(req.getParameter("id"));
        OrderItemService orderItemService = new OrderItemServiceImpl();
        //查询订单项
        List<OrderItem> orderItems = orderItemService.selectAllById(orderDTO.getId());
        //订单项
        orderDTO.setOrderItemList(orderItems);
        //放入request
        req.setAttribute("order",orderDTO);
        //查询商品信息
        ProductService productService = new ProductServiceImpl();
        List<Product> products = new ArrayList<>();
        for (OrderItem orderItem : orderItems) {
            Product product = productService.getProductById(orderItem.getProduct_id());
            products.add(product);
        }
        //放入request
        req.setAttribute("products",products);
        req.getRequestDispatcher("/admin/orderInfo.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}