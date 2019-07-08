package ylzl.domain;

import java.sql.Date;

public class User {
    /**
     * `id` int(11) NOT NULL AUTO_INCREMENT,
     *   `username` varchar(20) NOT NULL,
     *   `PASSWORD` varchar(20) NOT NULL,
     *   `gender` varchar(2) DEFAULT NULL,
     *   `email` varchar(50) DEFAULT NULL,
     *   `telephone` varchar(20) DEFAULT NULL,
     *   `introduce` varchar(100) DEFAULT NULL,
     *   `activeCode` varchar(50) DEFAULT NULL,
     *   `state` int(11) DEFAULT '0',
     *   `role` varchar(10) DEFAULT '普通用户',
     *   `registTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
     */
    private  int id; //用户编号
    private  String username;//用户名
    private  String password;//密码
    private  boolean gender;//性别
    private  String email;//邮件
    private  String telephone; //电话
    private  String introduce;//介绍
    private  String activeCode;//激活码
    private  int    state;//状态
    private  String role; //角色
    private  Date    registTime;//注册时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getActiveCode() {
        return activeCode;
    }

    public void setActiveCode(String activeCode) {
        this.activeCode = activeCode;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getRegistTime() {
        return registTime;
    }

    public void setRegistTime(Date registTime) {
        this.registTime = registTime;
    }
}
