package ylzl.web.servlet.manager;

import ylzl.domain.Product;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * @program: itcaststore
 * @description:
 * @author: Leo
 * @create: 2019-07-09 15:06
 **/
public class AddProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService productService = new ProductServiceImpl();
        Product product = new Product();
        product.setId(UUID.randomUUID().toString());
        product.setName(req.getParameter("name"));
        product.setPrice( Double.parseDouble(req.getParameter("price")));
        product.setDescription(req.getParameter("description"));
        product.setPnum(Integer.parseInt(req.getParameter("pnum")));
        product.setCategory(req.getParameter("category"));
        product.setImgurl(req.getParameter("imgurl"));
        int insert = productService.insert(product);
        if (insert <= 0){
            //放入错误提示信息
            req.getRequestDispatcher("").forward(req,resp);
        }
        else {
            //重定向至商品列表页
            resp.sendRedirect("/listProduct");
        }
    }
}