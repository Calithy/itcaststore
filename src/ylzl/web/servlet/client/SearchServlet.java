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
import java.util.List;

@WebServlet(name = "SearchServlet",
            urlPatterns = "/SearchServlet")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //模糊查询字符串
        String f_name = request.getAttribute("f_name").toString();
        String nowNum = request.getAttribute("pageName").toString();
        int pageNum = 0;
        int pageSize = 5;
        if(!nowNum.isEmpty()){
            pageNum = Integer.parseInt(nowNum);
        }
        ProductService productService = new ProductServiceImpl();
       // List<Product> productList = productService.findAllProductBynameWithPage(pageNum,pageSize,f_name);
       // request.setAttribute("productListWithPage",productList);
        request.getRequestDispatcher("显示页面").forward(request,response);


    }
}
