package cn.yang.springtest.jpa.dao;

import cn.yang.springtest.jpa.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {



}