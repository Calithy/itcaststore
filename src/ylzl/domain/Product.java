package ylzl.domain;

public class Product {
    /**
     *   `id` varchar(100) NOT NULL DEFAULT '',
     *   `name` varchar(40) DEFAULT NULL,
     *   `price` double DEFAULT NULL,
     *   `category` varchar(40) DEFAULT NULL,
     *   `pnum` int(11) DEFAULT NULL,
     *   `imgurl` varchar(100) DEFAULT NULL,
     *   `description` varchar(255) DEFAULT NULL,
     */
    private String id; //商品编号
    private String name;//商品名称
    private double price;//商品价格
    private String category; //商品类别
    private int    pnum; //商品数量
    private String imgurl;//商品图片地址
    private String description;//商品描述

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPnum() {
        return pnum;
    }

    public void setPnum(int pnum) {
        this.pnum = pnum;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}