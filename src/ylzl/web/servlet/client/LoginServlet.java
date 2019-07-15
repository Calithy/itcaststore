package ylzl.web.servlet.client;

import net.sf.json.JSON;
import net.sf.json.JSONObject;
import net.sf.json.JSONString;
import ylzl.domain.User;
import ylzl.service.UserService;
import ylzl.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;


@WebServlet(name = "LoginServlet",
            urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        HttpSession session = request.getSession();
        //登陆验证
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(),"utf-8"));
        String line = null;
        StringBuffer sb = new StringBuffer();
        while ((line = br.readLine()) != null){
            sb.append(line);
        }
        br.close();
        JSONObject json = JSONObject.fromObject(sb.toString());
        User l_user = (User) JSONObject.toBean(json,User.class);
        UserService userService = new UserServiceImpl();
        String u_name = l_user.getUsername();
        String pwd = l_user.getPassword();
        User user = userService.findUserByUsername(l_user.getUsername());
        String login_info =  null;
        session.setAttribute("user",user);
        if(user == null){
            login_info = "账号未注册，请先注册!";
        }else{
            if(user.getState() != true){
                login_info = "账号未激活!";
            }
            if(!user.getUsername().equals(u_name) || !user.getPassword().equals(pwd)){
                login_info = "账号或密码错误!";
            }else {
                System.out.println(request.getContextPath() + "/myAccount.jsp");
                if (user.getRole().equals("超级用户")) {
                    response.setHeader("redirectUrl",request.getContextPath() + "/admin/home.jsp");
                    response.setHeader("enableRedirect","true");
                } else {
                    response.setHeader("redirectUrl",request.getContextPath() + "/myAccount.jsp");
                    response.setHeader("enableRedirect","true");
                }
                return ;
            }
        }
        /*
            返回json数据
        * */

        String infoJson = "{\"login_info\": "+login_info +"}";
        PrintWriter out = response.getWriter();
        out.println(infoJson);
        out.flush();
    }


}
