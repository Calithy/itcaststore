package ylzl.utils;

import ylzl.domain.User;

import javax.servlet.ServletRequest;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GenerateLinkUtils {
    private static final String CHECK_CODE = "checkCode";

    /**
     * 生成激活链接
     * @param user
     * @return
     */
    public  static String generateActivateLink(User user){
        return "http://localhost:8080/itcaststore/ActivateServlet?id="
                + user.getId() + "&" + CHECK_CODE + "=" + generateCheckcode(user);
    }

    /**
     * 生成验证码
     * @param user
     * @return
     */
    public static String generateCheckcode(User user){
        String userName = user.getUsername();
        String randomCode = user.getActiveCode();
        return md5(userName + ":" + randomCode);
    }

    /**
     * 验证接收回来的验证码与发出去的验证码是否相同
     * @param user
     * @param request
     * @return
     */
    public  static  boolean verifyCheckcode(User user, ServletRequest request){
        String checkCode = request.getParameter(CHECK_CODE);
        if(generateCheckcode(user).equals(checkCode)) return  true;
        else  return false;
    }

    /**
     * 验证码加密
     * @param str
     * @return
     */
    private static String md5(String str){
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("md5");
            md.update(str.getBytes());
            byte[] md5Bytes = md.digest();
            return bytes2Hex(md5Bytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将加密后的checkcode转化为16进制字符串
     * @param byteArray
     * @return
     */
    private static String bytes2Hex(byte[] byteArray){
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0; i < byteArray.length;i++){
            if(byteArray[i] >= 0 && byteArray[i] < 16){
                stringBuffer.append("0");
            }
            stringBuffer.append(Integer.toHexString(byteArray[i] & 0xFF));
        }
        return stringBuffer.toString();
    }

}
