package com.aps.demo.service;

import com.aps.demo.entity.Blog;
import com.aps.demo.model.BlogDataResponse;

import java.util.List;

public interface BlogService {
    public long save(Blog blog);
    public List<Blog> getBlogList(long userid, int page, int pageSize);
}
