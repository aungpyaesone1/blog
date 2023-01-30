package com.aps.demo.controller;

import com.aps.demo.entity.Blog;
import com.aps.demo.model.BaseResponse;
import com.aps.demo.model.BlogDataResponse;
import com.aps.demo.service.BlogService;
import com.aps.demo.util.ResponseEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Blog blog){
        BaseResponse res = new BaseResponse();
        long syskey = blogService.save(blog);
        res.setStatus_code(ResponseEnum.ResponseCode.SUCCESS.code());
        res.setStatus_message(ResponseEnum.ResponseMessage.SAVE_SUCCESS.message());
        res.setSyskey(syskey);
        return ResponseEntity.ok().body(res);
    }

    @GetMapping("/{userid}")
    public ResponseEntity<?> getBlogList(@PathVariable long userid, @RequestParam(defaultValue = "0")int page,@RequestParam(defaultValue = "50")int pageSize){
        BlogDataResponse response = new BlogDataResponse();
        List<Blog> blogs = blogService.getBlogList(userid, page, pageSize);
        response.setStatus_code(ResponseEnum.ResponseCode.SUCCESS.code());
        response.setStatus_message(ResponseEnum.ResponseMessage.SUCCESS.message());
        response.setBlogList(blogs);
        return ResponseEntity.ok().body(response);
    }
}
