package org.dingli.controller;

import org.dingli.service.UserService;
import org.dingli.common.CommonResult;
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
    public CommonResult<Object> getName(@PathVariable("id") String id) {
//        String key = null;
//        System.out.println(key.toLowerCase(Locale.ROOT));
        int i = 1/0;
        System.out.println(i);
        return CommonResult.success(userService.getName(id));
    }
}