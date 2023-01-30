package com.aps.demo.service.Impl;

import com.aps.demo.entity.Blog;
import com.aps.demo.model.BlogDataResponse;
import com.aps.demo.repository.BlogRepository;
import com.aps.demo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository blogRepository;
    @Override
    public long save(Blog blog) {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String date = dateTime.format(formatter);
        blog.setCreateddate(date);
        blog.setModifieddate(date);
        blog.setRecordstatus(1);
        return blogRepository.save(blog).getSyskey();
    }

    @Override
    public List<Blog> getBlogList(long userid, int page, int pageSize) {
        Pageable pageable= PageRequest.of(page, pageSize);
        return blogRepository.findAll();
    }
}
