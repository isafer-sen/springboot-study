package com.example.demo.entity;

import lombok.Data;

import java.util.Date;


@Data
public class User {
    private Integer id;
    private String username;
    private Integer age;
    private Date createdAt;
    private Date updatedAt;
}
