package com.gityang.springtest.jpa.dao;

import com.gityang.springtest.jpa.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {



}
