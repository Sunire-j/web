package com.team2.healthsns.mapper;

import com.team2.healthsns.vo.CommunityVO;
import com.team2.healthsns.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    public UserVO UserSelectAll(String id);
    public String GetSessionEmail(String logId);
    public List<UserVO> GetFollowRanking();
    public List<CommunityVO> getTopPostsByDate(String date);
}
