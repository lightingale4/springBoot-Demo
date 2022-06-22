package org.dingli.controller;

import org.dingli.Service.UserService;
import org.dingli.dto.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;

    @PostMapping("/addUser")
    public String addUser(@RequestBody UserDto userEntity) {
        return userService.add(userEntity.getName(), userEntity.getAge(), userEntity.getHobbies());
    }

    @GetMapping("/getName/{id}")
    public String getName(@PathVariable("id") String id) {
        return userService.getName(id);
    }
}