package com.team2.healthsns.service;

import com.team2.healthsns.mapper.MinihomeMapper;
import com.team2.healthsns.vo.UserVO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class MinihomeServicempl implements MinihomeService {
    @Inject
    MinihomeMapper mapper;

    @Override
    public UserVO userSelect(String id) {
        return mapper.userSelect(id);
    }
}
