package ylzl.web.servlet.client;


import net.sf.json.JSONObject;
import net.sf.json.processors.JsonBeanProcessor;
import ylzl.domain.User;
import ylzl.service.UserService;
import ylzl.service.impl.UserServiceImpl;
import ylzl.utils.EmailUtils;

import javax.servlet.ServletException;;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Date;
import java.util.UUID;

@WebServlet(name = "RegisterServlet",
            urlPatterns = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //利用Json接受数据

        response.setContentType("application/json");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(),"utf-8"));
        StringBuffer sb = new StringBuffer("");
        String line = null;
        while ((line = br.readLine()) != null){
            sb.append(line);

        }
        br.close();
        JSONObject json = JSONObject.fromObject(sb.toString());
        UserService userService = new UserServiceImpl();
        User r_user = (User)JSONObject.toBean(json,User.class);
        User user = userService.findUserByUsername(r_user.getUsername());
        String desc = r_user.getIntroduce();
        String info = null;
        if(user == null){
            /*插入数据库*/
            String code = UUID.randomUUID().toString(); //生成checkcode
            r_user.setActiveCode(code);
            r_user.setState(false);
            r_user.setRegistTime(new Date());
            r_user.setRole("普通用户");
            userService.insert(r_user);
        }else{
            info = "用户已注册!";
        }
        EmailUtils.sendAccountActivateEmail(r_user);
        String infoJson = "{\"res_info\": "+info +"}";
        String jsonUser = JSONObject.fromObject(user).toString();
        PrintWriter out = response.getWriter();
        out.println(infoJson);
        out.println(jsonUser);
        out.flush();
        response.setHeader("redirectUrl",request.getContextPath() + "/myAccount.jsp");
        response.setHeader("enableRedirect","true");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
