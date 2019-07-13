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
import java.util.Map;

@WebServlet(name = "ChangeServlet",
            urlPatterns = "/ChangeServlet")
public class ChangeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int count = Integer.parseInt(request.getParameter("count"));
        HttpSession session = request.getSession();
        Map<Product, Integer> cart = (Map)session.getAttribute("cart");


        Product p = new Product();
        p.setId(id);
        if (count != 0) {
           cart.put(p,count);
        } else {
            cart.remove(p);
        }

        response.sendRedirect(request.getContextPath() + "/cart.jsp");
    }
}
