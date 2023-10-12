package com.team2.healthsns.service;

import com.team2.healthsns.mapper.UserMapper;
import com.team2.healthsns.vo.UserVO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class UserServicempl implements UserService {
    @Inject
     UserMapper mapper;

    @Override
    public UserVO UserSelectAll(String id) {
        return mapper.UserSelectAll(id);
    }

    @Override
    public String GetSessionEmail(String logId) {
        return mapper.GetSessionEmail(logId);
    }
}
