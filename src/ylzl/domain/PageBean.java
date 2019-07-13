package ylzl.domain;

import java.util.List;

public class PageBean {
    private int pageNum; //当前页
    private int pageSize; //每页显示的条数
    private int totalRecord;//总记录条数

    //需计算得到
    private int totalPage; //总页数

    private int startIndex; //当前索引

    private List<Product> list; //当前页要显示的商品集合

    private int startPage; //起始页面
    private int endPage;//结束页

    public PageBean(int pageNum,int pageSize,int totalRecord){
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalRecord = totalRecord;
        //totalPage = totalRecord / pageSize

        if(totalRecord % pageSize == 0){
            this.totalPage = totalRecord / pageSize;
        }else {
            this.totalPage = totalRecord / pageSize + 1;
        }

        this.startIndex = (pageNum - 1) * pageSize;

        this.startPage = 1;
        this.endPage = 4;

        //显示页面的算法，共显示5页
        if(totalPage <= 4){
            this.endPage = this.totalPage;
        }else{
            this.startPage = pageNum - 2;
            this.endPage = pageNum + 2;
            if(startPage <= 0){
                this.startPage = 2;
                this.endPage = 3;
            }
            if(endPage >= this.totalPage){
                this.endPage = this.totalPage;
                this.startPage = this.endPage - 4;
            }
        }
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<Product> getList() {
        return list;
    }

    public void setList(List<Product> list) {
        this.list = list;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
}
