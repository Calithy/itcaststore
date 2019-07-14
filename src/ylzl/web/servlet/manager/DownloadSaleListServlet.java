package ylzl.web.servlet.manager;

import ylzl.service.ProductService;
import ylzl.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @program: itcaststore
 * @description: 下载销售榜单Servlet
 * @author: Leo
 * @create: 2019-07-14 17:13
 **/
@WebServlet(name = "downloadSaleList", urlPatterns = {"/downloadSaleList"})
public class DownloadSaleListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService productService = new ProductServiceImpl();
        String year = req.getParameter("year");
        String month = req.getParameter("month");
        List<Object[]> saleList = productService.selectSaleList(year, month);
        String fileName = String.format("%04d年%02d月销售榜单.csv",Integer.parseInt(year),Integer.parseInt(month));
        resp.setContentType(getServletContext().getMimeType(fileName));
        resp.setHeader("Content-Disposition", "attachement;filename=" + new String(fileName.getBytes("GBK"), "iso8859-1"));
        resp.setCharacterEncoding("gbk");
        PrintWriter out = resp.getWriter();
        out.println("商品名称,销售数量");
        for (Object[] objects : saleList) {
            out.println(objects[0] + "," + objects[1]);
        }
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}