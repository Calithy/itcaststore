package ylzl.web.servlet.client;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ShowAllProductsServlet",
            urlPatterns = "/ShowAllProductsServlet")
public class ShowAllProductsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("charst","utf-8");
        int pageSize = 4;
        String nowNum = request.getAttribute("PageNum").toString();
        int pageNum = 0;
        if(!nowNum.isEmpty()){
            pageNum = Integer.parseInt(nowNum);
        }

    }
}
