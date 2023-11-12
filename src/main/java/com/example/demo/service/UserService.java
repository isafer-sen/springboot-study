package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    public List<User> findAll() {
        return userMapper.findAll();
    }

    public Integer insert(String username, Integer age) {
        return userMapper.insert(username, age);
    }

    public User show(Integer id) {
        return userMapper.show(id);
    }

    public Integer update(User user) {
        return userMapper.update(user);
    }

    public Integer delete(Integer id) {
        return userMapper.delete(id);
    }
}
