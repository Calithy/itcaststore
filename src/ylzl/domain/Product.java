package ylzl.domain;

import java.io.Serializable;

public class Product implements Serializable {
    private String id; //商品编号
    private String name;//商品名称
    private double price;//商品价格
    private String category; //商品类别
    private int    pnum; //商品数量
    private String imgurl;//商品图片地址
    private String description;//商品描述

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + (this.id == null ? 0 : this.id.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (this.getClass() != obj.getClass()) {
            return false;
        } else {
            Product other = (Product)obj;
            if (this.id == null) {
                if (other.id != null) {
                    return false;
                }
            } else if (!this.id.equals(other.id)) {
                return false;
            }

            return true;
        }
    }
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

    public String getImgurl_s() {
        int index = this.imgurl.lastIndexOf(".");
        String first = this.imgurl.substring(0, index);
        String last = this.imgurl.substring(index);
        return first + "_s" + last;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", pnum=" + pnum +
                ", imgurl='" + imgurl + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
