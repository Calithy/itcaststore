package ylzl.web.servlet.manager;

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

/**
 * @program: itcaststore
 * @description: 展示所有商品信息
 * @author: Leo
 * @create: 2019-07-09 14:37
 **/
@WebServlet(name = "listProduct", urlPatterns = {"/listProduct"})
public class ListProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService productService = new ProductServiceImpl();
        //查询出所有商品信息 以及分类信息
        List<Product> products = productService.listAllProducts();
        List<String> categories = productService.getProductCategory();
        //加入request域
        req.setAttribute("products",products);
        req.setAttribute("categories",categories);
        //转发
        req.getRequestDispatcher("/admin/productManage.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}