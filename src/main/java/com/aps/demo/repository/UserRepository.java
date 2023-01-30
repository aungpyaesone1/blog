package com.aps.demo.repository;

import com.aps.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsernameAndPasswordAndRecordstatus(String username, String password, int recordstatus);
}
