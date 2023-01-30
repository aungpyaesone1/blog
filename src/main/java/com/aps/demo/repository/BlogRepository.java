package com.aps.demo.repository;

import com.aps.demo.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
    @Query("select new com.aps.demo.entity.Blog(b.syskey,b.title,b.content,b.createddate,b.modifieddate) from Blog as b where b.userid=:userid and b.recordstatus=:recordstatus")
    public Page<Blog> findBlogListByUserid(Pageable pageable, long userid, int recordstatus);
}
