package ylzl.web.servlet.client;

import ylzl.dao.ProductDao;
import ylzl.dao.impl.ProductDaoImpl;
import ylzl.domain.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchServlet",
            urlPatterns = "/SearchServlet")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        //模糊查询字符串
        String f_name = session.getAttribute("f_name").toString();
        ProductDao productDao = new ProductDaoImpl();
        List<Product> productList = productDao.findByStr(f_name);
        
    }
}
