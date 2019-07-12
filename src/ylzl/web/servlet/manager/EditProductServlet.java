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
 * @description: 编辑商品 Servlet
 * @author: Leo
 * @create: 2019-07-09 15:44
 **/
@WebServlet(name = "editProduct", urlPatterns = {"/editProduct"})
public class EditProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService productService = new ProductServiceImpl();
        String id = req.getParameter("id");
        if (id != null && !"".equals(id)){
            //查询商品信息
            Product product = productService.getProductById(id);
            //加入request域
            req.setAttribute("product",product);
        }
        //获取所有商品分类
        List<String> categories = productService.getProductCategory();
        //加入request域
        req.setAttribute("categories", categories);
        //转发至编辑页面
        req.getRequestDispatcher("/admin/editProduct.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}