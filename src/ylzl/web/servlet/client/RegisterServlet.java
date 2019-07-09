package ylzl.web.servlet.client;

import ylzl.dao.UserDao;
import ylzl.dao.impl.UserDaoImpl;
import ylzl.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "RegisterServlet",
            urlPatterns = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        HttpSession session = request.getSession();
        String email = session.getAttribute("eamil").toString();
        String u_name = session.getAttribute("u_name").toString();
        String pwd = session.getAttribute("pwd").toString();
        String sex = session.getAttribute("sex").toString();
        String phone = session.getAttribute("phone").toString();
        String description = session.getAttribute("description").toString();
        UserDao userDao = new UserDaoImpl();
        User user = userDao.getByUsername("u_name");
        String info = null;
        if(user == null){
            /*插入数据库*/
        }else{
            info = "用户已注册!";
        }
        session.setAttribute("message",info);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
