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

@WebServlet(name = "UserInfoChangeServlet",
            urlPatterns = "/UserInfoChangeServlet")
public class UserInfoChangeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        UserService userService = new UserServiceImpl();
        String username = request.getParameter("username");
        String pwd = request.getParameter("password");
        String phone = request.getParameter("phone");
        String gender = request.getParameter("gender");
        User user = userService.findUserByUsername(username);
        System.out.println(pwd + phone + gender);
        if(!pwd.isEmpty() && !phone.isEmpty()){
            user.setPassword(pwd);
            user.setTelphone(phone);
            user.setGender(gender);
        }

        int row = userService.update(user);

        response.sendRedirect("myAccount.jsp");



    }
}
