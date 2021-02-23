package com.controller;


import com.model.User;
import com.service.UserService;

import java.util.List;
import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController {
    private Logger log = Logger.getLogger(UserController.class);
    @Resource
    private UserService userService;

    //@ResponseBody
    @RequestMapping(value = "/showUser", produces = "application/json;charset=UTF-8")
    //@ResponseBody
    public String showUser(Model model, @RequestParam("userName") String name, @RequestParam("userPwd") String password) {
        log.info("查询所有用户信息");
        log.info("RequestParam:::" + name);
        log.info("Request:" + password);
        List<User> userList = userService.getAllUser();
        model.addAttribute("userList", userList);
        return "showUser";
    }

    @RequestMapping(value = "/aa", method = RequestMethod.GET)
    public String showUsers(Model model) {
        //System.out.println("1111111111");
        log.info("查询所有用户信息233");
        List<User> userList = userService.getAllUser();
        //System.out.println(userList.size());
        log.info(userList.size());
        model.addAttribute("userLIst", userList);
        return "showUser";
    }
}
