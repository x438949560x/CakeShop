package com.ccsu.domain;

import java.util.List;

// 分页的数据模型
public class Page {
    private int pageNumber;  // 当前是第几页
    private int pageSize;  // 每一页显示多少条数据
    private int totalCount; // 总记录数
    private int totalPage; // 总页数
    private int sortId; // 排序

    public int getSortId() {
        return sortId;
    }

    public void setSortId(int sortId) {
        this.sortId = sortId;
    }

    private List<Object> list; // 数据集合,存放的东西不可知

    public void setPageSizeAndTotalCount(int pageSize, int totalCount) {
        // 每页显示多少个 总记录数  向上取整
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.totalPage = (int)Math.ceil((double) totalCount/pageSize);
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }
}
