package ylzl.dto;

import ylzl.domain.OrderItem;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @program: itcaststore
 * @description: 订单传输对象
 * @author: Leo
 * @create: 2019-07-11 15:27
 **/
public class OrderDTO implements Serializable {
    private String id; //订单编号
    private double money;//商品价格
    private String receiverAddress;//收获地址
    private String receiverName;//收货人姓名
    private String receiverPhone;//收货人电话
    private String paystate;//支付状态
    private Date ordertime;//订单时间
    private int userId;//所属用户ID
    private String userName;//所属用户姓名
    private List<OrderItem> orderItemList; //订单详情

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public String getPaystate() {
        return paystate;
    }

    public void setPaystate(String paystate) {
        this.paystate = paystate;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "id='" + id + '\'' +
                ", money=" + money +
                ", receiverAddress='" + receiverAddress + '\'' +
                ", receiverName='" + receiverName + '\'' +
                ", receiverPhone='" + receiverPhone + '\'' +
                ", paystate='" + paystate + '\'' +
                ", ordertime=" + ordertime +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }
}