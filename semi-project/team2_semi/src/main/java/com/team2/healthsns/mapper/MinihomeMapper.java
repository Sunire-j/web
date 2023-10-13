package com.team2.healthsns.mapper;

import com.team2.healthsns.vo.CommunityVO;
import com.team2.healthsns.vo.MemoVO;
import com.team2.healthsns.vo.UserVO;
import com.team2.healthsns.vo.GuestbookVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MinihomeMapper {
    public UserVO UserSelect(String id);
    public List<String> FollowerSelect(String id);
    public int FollowSelect(String id);
    public List<GuestbookVO> GuestbookSelect(String id);
    public int GuestbookInsert(GuestbookVO gvo);
    public int GuestbookDelete(int guestbookid);
    public int FollowDelete(String id, String userid);
    public int FollowInsert(String id, String userid);
    public void VisitInsert(String id, String userid);
    public int CountToday(String id);
    public int MemoInsert(MemoVO mVO);
    public MemoVO MemoSelect(int no);
    public int CountMemo(String id);
    public List<MemoVO> MemoListSelect(String id, int month, int year);
    public int MemoToAuth(CommunityVO bvo);
}
