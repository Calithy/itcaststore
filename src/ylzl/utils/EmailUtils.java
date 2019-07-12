package ylzl.utils;

import ylzl.domain.User;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

import static javax.mail.Message.RecipientType;

/**
 * 发送邮件
 */
public class EmailUtils {
    private static final String FROM = "yl_5617@163.com";

    /**
     * 发送邮件
     * @param user
     */
    public static void sendAccountActivateEmail(User user) {
        Session session = getSession();
        MimeMessage message = new MimeMessage(session);
        try {
            message.setSubject("这是一封激活账号的邮件，复制链接到地址栏来激活他");
            message.setSentDate(new Date());
            message.setFrom(new InternetAddress(FROM));
            message.setRecipient(RecipientType.TO,new InternetAddress(user.getEmail()));
            message.setContent("<a target='_BLANK' href=''>" + GenerateLinkUtils.generateActivateLink(user) + "</a>" ,
                    "text/html;charset=utf-8");
            Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

    /**
     * 发送邮件的邮箱设置
     * @return Session
     */
    public static Session getSession() {
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol","smtp");
        props.setProperty("mail.smtp.host","smtp.163.com");
        props.setProperty("mail.smtp.port","25");
        props.setProperty("mail.smtp.auth","true");
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(FROM,"li123456789");
            }
        });
        return session;
    }

}
