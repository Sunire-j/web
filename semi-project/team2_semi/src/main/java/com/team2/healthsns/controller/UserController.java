package com.team2.healthsns.controller;

import com.team2.healthsns.mapper.UserMapper;
import com.team2.healthsns.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired
    UserService service;
}
