package ylzl.web.servlet.client;

import ylzl.dao.UserDao;
import ylzl.dao.impl.UserDaoImpl;
import ylzl.domain.User;
import ylzl.utils.EmailUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;

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
            User r_user = new User();
            r_user.setEmail(email);
            r_user.setUsername(u_name);
            r_user.setGender(sex);
            r_user.setRole("普通用户");
            r_user.setState(false); //默认未激活且为普通用户
            String code = UUID.randomUUID().toString(); //生成checkcode
            userDao.insert(user);
        }else{
            info = "用户已注册!";
        }
        user = userDao.getByUsername(u_name);
        session.setAttribute("user",user);
        EmailUtils.sendAccountActivateEmail(user);
        session.setAttribute("message",info);
        /**
         * 跳转到登陆界面
         */
       // response.sendRedirect("/WEB-INF/");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
