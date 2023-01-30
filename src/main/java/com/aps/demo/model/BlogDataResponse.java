package com.aps.demo.model;

import com.aps.demo.entity.Blog;

import java.util.ArrayList;
import java.util.List;

public class BlogDataResponse extends BaseResponse{
    private long totalItems;
    private int totalPages;
    private int currentPage;
    private List<Blog> blogList = new ArrayList<>();

    public long getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(long totalItems) {
        this.totalItems = totalItems;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public List<Blog> getBlogList() {
        return blogList;
    }

    public void setBlogList(List<Blog> blogList) {
        this.blogList = blogList;
    }
}
