package ylzl.web.servlet.client;

import ylzl.domain.User;
import ylzl.service.UserService;
import ylzl.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "UserInfoChangeServlet")
public class UserInfoChangeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String pwd = request.getParameter("pwd");
        String phone = request.getParameter("phone");
        String gender = request.getParameter("gender");
        user.setPassword(pwd);
        user.setTelephone(phone);
        user.setGender(gender);
        UserService userService = new UserServiceImpl();
        int row = userService.update(user);
        if(row != 0){
            response.sendRedirect("成功修改页面");
        }else{
            /*
            * 提示修改失败*/
        }



    }
}
