package com.team2.healthsns.service;

import com.team2.healthsns.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class UserServicempl implements UserService {
    @Inject
    UserService mapper;
}
