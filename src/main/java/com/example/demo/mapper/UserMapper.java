package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> findAll();

    Integer insert(String username, Integer age);

    User show(Integer id);

    Integer update(User user);

    Integer delete(Integer id);
}
