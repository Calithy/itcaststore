package ylzl.web.servlet.manager;

import ylzl.service.ProductService;
import ylzl.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: itcaststore
 * @description: 删除商品信息Servlet
 * @author: Leo
 * @create: 2019-07-09 16:41
 **/
public class DeleteProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        ProductService productService = new ProductServiceImpl();
        int delete = productService.delete(id);
        //删除失败
        if (delete <= 0){

        }
        //删除成功
        else {
            req.getRequestDispatcher("").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}