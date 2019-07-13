package ylzl.web.servlet.client;

import ylzl.domain.PageBean;
import ylzl.domain.Product;
import ylzl.service.ProductService;
import ylzl.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowAllProductsServlet",
            urlPatterns = "/ShowAllProductsServlet")
public class ShowAllProductsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("charset","utf-8");
        int pageSize = 4;
        String nowNum = request.getParameter("PageNum");
        int pageNum = 1;
        if(nowNum != null){
            pageNum = Integer.parseInt(nowNum);
        }
        ProductService productService = new ProductServiceImpl();
         PageBean pageBean = productService.listProductWithPage(pageNum,pageSize);
         request.setAttribute("pageBean",pageBean);
         //request.setAttribute("pageNum",pageNum);
         request.getRequestDispatcher("booklist.jsp").forward(request,response);
    }
}
