package ylzl.web.servlet.client;

import ylzl.domain.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "ChangeServletServlet")
public class ChangeServletServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String p_id = request.getAttribute("id").toString();//获得商品id
        String strcount = request.getAttribute("count").toString(); //商品数量
        int count = -1;
        if(!strcount.isEmpty()){
            count = Integer.parseInt(strcount);
        }
        Map<Product,Integer> cart = (Map<Product, Integer>) request.getSession().getAttribute("cart");
        Product product = new Product();
        product.setId(p_id);
        if(count == 0){
            cart.remove(product);
        }else{
            cart.put(product,count);
        }
        /*
        * 跳转到购物车页面显示*/
        //response.sendRedirect(request.getContextPath() + "/client/cart.jsp");
    }
}
