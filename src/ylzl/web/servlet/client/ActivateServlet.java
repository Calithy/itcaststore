package ylzl.web.servlet.client;

import ylzl.dao.UserDao;
import ylzl.dao.impl.UserDaoImpl;
import ylzl.domain.User;
import ylzl.service.UserService;
import ylzl.service.impl.UserServiceImpl;
import ylzl.utils.GenerateLinkUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "ActivateServlet",
            urlPatterns = "/ActivateServlet")
public class ActivateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idValue = req.getParameter("id");
        int id = -1;
        if(!idValue.isEmpty()){
            id = Integer.parseInt(idValue);
        }
        UserService userService = new UserServiceImpl();
        User user = userService.findUserById(id);
        //user.setState(true);
        if(GenerateLinkUtils.verifyCheckcode(user,req)){
            user.setState(true);
            req.getSession().setAttribute("user",user);
            /**
             * 跳转到激活成功页面
             */
           // req.getRequestDispatcher()
            /*转发到哪*/
        }
    }
}
