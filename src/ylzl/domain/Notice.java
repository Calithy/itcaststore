package ylzl.domain;


import java.io.Serializable;

public class Notice implements Serializable {
    private int n_id;  //公告编号
    private String title; //公告标题
    private String details;//公告详情
    private String n_time; //公告时间

    public int getN_id() {
        return n_id;
    }

    public void setN_id(int n_id) {
        this.n_id = n_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getN_time() {
        return n_time;
    }

    public void setN_time(String n_time) {
        this.n_time = n_time;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "n_id=" + n_id +
                ", title='" + title + '\'' +
                ", details='" + details + '\'' +
                ", n_time='" + n_time + '\'' +
                '}';
    }
}
