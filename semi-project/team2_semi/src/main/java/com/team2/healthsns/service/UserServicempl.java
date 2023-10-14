package com.team2.healthsns.service;

import com.team2.healthsns.mapper.UserMapper;
import com.team2.healthsns.vo.CommunityVO;
import com.team2.healthsns.vo.UserVO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

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

    @Override
    public List<UserVO> GetFollowRanking() {
        return mapper.GetFollowRanking();
    }

    @Override
    public List<CommunityVO> getTopPostsByDate(String date) {
        return mapper.getTopPostsByDate(date);
    }

}
