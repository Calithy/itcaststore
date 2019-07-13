package ylzl.web.servlet.client;

import ylzl.domain.Product;
import ylzl.service.ProductService;
import ylzl.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name = "FindProductByIdServlet",
        urlPatterns = "/FindProductByIdServlet")
public class FindProductByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String p_id = req.getParameter("id");
        ProductService productService = new ProductServiceImpl();
        Product product = productService.getProductById(p_id);
        req.setAttribute("product",product);
        req.getRequestDispatcher("bookdetail.jsp").forward(req,resp);
    }
}
