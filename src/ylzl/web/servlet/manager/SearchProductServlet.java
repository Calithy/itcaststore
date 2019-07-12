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
 * @description: 搜索商品Servlet
 * @author: Leo
 * @create: 2019-07-12 15:09
 **/
@WebServlet(name = "searchProduct", urlPatterns = {"/searchProduct"})
public class SearchProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService productService = new ProductServiceImpl();
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String category = req.getParameter("category");
        String minPrice = req.getParameter("minPrice");
        String maxPrice = req.getParameter("maxPrice");
        int min = 0;
        int max = -1;
        if ((minPrice != null && minPrice.trim().length() > 0) &&
            maxPrice != null && maxPrice.trim().length() > 0){
            min = Integer.parseInt(minPrice);
            max = Integer.parseInt(maxPrice);
        }
        //所有条件都为空 -> 查询所有
        if ((id == null || id.trim().length() <= 0)
                && (name == null || name.trim().length() <= 0)
                && (category == null || category.trim().length() <= 0)
                && (minPrice == null || minPrice.trim().length() <= 0)
                && (maxPrice == null || maxPrice.trim().length() <= 0)){
            resp.sendRedirect(req.getContextPath() + "/listProduct");
        }
        else {
            //查询出符合条件的商品信息 以及分类信息（查询条件中需要）
            List<Product> products = productService.selectByConditions(id,name,category,min,max);
            req.setAttribute("products",products);
            List<String> categories = productService.getProductCategory();
            req.setAttribute("categories",categories);
            req.getRequestDispatcher("/admin/productManage.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}