package com.sanjay.springmysql.repository;

import com.sanjay.springmysql.daoJPA.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUserName(String username);
}
