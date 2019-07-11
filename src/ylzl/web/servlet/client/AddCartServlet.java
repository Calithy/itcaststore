package ylzl.web.servlet.client;

import ylzl.domain.Product;
import ylzl.service.ProductService;
import ylzl.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

@WebServlet(name = "AddCartServlet",
            urlPatterns = "/AddCartServlet")
public class AddCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String p_id = request.getAttribute("Id").toString(); //前端页面传来的商品Id
        ProductService productService = new ProductServiceImpl();
        Product product = productService.getProductById(p_id);
        HttpSession session = request.getSession();
        Map<Product,Integer> cart = (Map<Product, Integer>)session.getAttribute("cart"); //前端传来的购物车map
        if(cart == null){
            cart = new LinkedHashMap<>();
        }else{
            if(cart.containsKey(product)){
                Integer count = cart.get(product);
                cart.replace(product,count + 1); //更新购物车数量
            }else{
                cart.put(product,1); //新增购物车商品
            }
        }
        session.setAttribute("cart",cart);
        response.sendRedirect("购物车页面路径");

    }
}
