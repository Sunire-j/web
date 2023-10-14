package com.team2.healthsns.service;

import com.team2.healthsns.vo.CommunityVO;
import com.team2.healthsns.vo.UserVO;

import java.util.List;

public interface UserService {
    public UserVO UserSelectAll(String id);
    public String GetSessionEmail(String logId);
    public List<UserVO> GetFollowRanking();
    public List<CommunityVO> getTopPostsByDate(String date);
}
