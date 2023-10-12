package com.team2.healthsns.mapper;

import com.team2.healthsns.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public UserVO UserSelectAll(String id);
    public String GetSessionEmail(String logId);
}
