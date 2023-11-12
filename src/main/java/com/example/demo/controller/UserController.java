package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.helpers.R;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("/index")
    public R index() {
        return R.success(userService.findAll());
    }

    @PostMapping("/insert")
    public R insert(@RequestParam String username, Integer age) {
        if (userService.insert(username, age) > 0) {
            return R.success(null);
        }
        return R.failed();
    }

    @GetMapping("/show/{id}")
    public R insert(@PathVariable Integer id) {
        return R.success(userService.show(id));
    }

    @PostMapping("/update")
    public R update(@RequestBody User user) {
        if (userService.update(user) > 0) {
            return R.success(null);
        }
        return R.failed();
    }

    @PostMapping("/delete/{id}")
    public R delete(@PathVariable Integer id) {
        if (userService.delete(id) > 0) {
            return R.success(null);
        }
        return R.failed();
    }
}
