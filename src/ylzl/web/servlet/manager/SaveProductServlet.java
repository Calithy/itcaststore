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
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

/**
 * @program: itcaststore
 * @description:
 * @author: Leo
 * @create: 2019-07-09 15:06
 **/
@WebServlet(name = "saveProduct", urlPatterns = {"/saveProduct"})
public class SaveProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService productService = new ProductServiceImpl();
        Product product = new Product();
        boolean add = false;
        String id = req.getParameter("id");
        List<String> ids = productService.listAllIds();
        //ID为空 添加
        if (id == null || id.trim().length() <= 0){
            String generatedId = generateNoRepeatedId(ids);
            product.setId(generatedId);
            add = true;
        }
        //修改
        else {
            product.setId(id);
        }
        product.setName(req.getParameter("name"));
        product.setPrice( Double.parseDouble(req.getParameter("price")));
        product.setDescription(req.getParameter("description"));
        product.setPnum(Integer.parseInt(req.getParameter("pnum")));
        product.setCategory(req.getParameter("category"));
        product.setImgurl(req.getParameter("imgurl"));
        if (add){
            int insert = productService.insert(product);
            if (insert <= 0){
                //放入错误提示信息
                req.setAttribute("message","添加商品信息失败");
                req.getRequestDispatcher("/editProduct").forward(req,resp);
                req.getRequestDispatcher("/admin/editProduct.jsp").forward(req,resp);
            }
        }
        else {
            int update = productService.update(product);
            if (update <= 0){
                //放入错误提示信息
                req.setAttribute("message","修改商品信息失败");
                req.getRequestDispatcher("/editProduct").forward(req,resp);
                req.getRequestDispatcher("/admin/productManage.jsp").forward(req,resp);
            }
        }
        //重定向至商品列表页
        resp.sendRedirect(req.getContextPath() + "/listProduct");
    }
    /**
     * 生成不重复ID
     * @param ids
     * @return
     */
    private String generateNoRepeatedId(List<String> ids){
        String id = null;
        HashSet<String> set = new HashSet<>(ids);
        do {
            id = UUID.randomUUID().toString();
        }while (!set.add(id));
        return id;
    }
}