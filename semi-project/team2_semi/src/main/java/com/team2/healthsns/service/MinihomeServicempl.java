package com.team2.healthsns.service;

import com.team2.healthsns.mapper.MinihomeMapper;
import com.team2.healthsns.vo.CommunityVO;
import com.team2.healthsns.vo.MemoVO;
import com.team2.healthsns.vo.UserVO;
import com.team2.healthsns.vo.GuestbookVO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class MinihomeServicempl implements MinihomeService {
    @Inject
    MinihomeMapper mapper;

    @Override
    public UserVO UserSelect(String id) {
        return mapper.UserSelect(id);
    }

    @Override
    public List<String> FollowerSelect(String id) {
        return mapper.FollowerSelect(id);
    }

    @Override
    public int FollowSelect(String id) {
        return mapper.FollowSelect(id);
    }

    @Override
    public List<GuestbookVO> GuestbookSelect(String id) {
        return mapper.GuestbookSelect(id);
    }

    @Override
    public int GuestbookInsert(GuestbookVO gvo) {
        return mapper.GuestbookInsert(gvo);
    }

    @Override
    public int GuestbookDelete(int guestbookid) {
        return mapper.GuestbookDelete(guestbookid);
    }

    @Override
    public int FollowDelete(String id, String userid){
        return mapper.FollowDelete(id, userid);
    }

    @Override
    public int FollowInsert(String id, String userid) {
        return mapper.FollowInsert(id, userid);
    }

    @Override
    public void VisitInsert(String id, String userid) {
        mapper.VisitInsert(id, userid);
    }

    @Override
    public int CountToday(String id) {
        return mapper.CountToday(id);
    }

    @Override
    public int MemoInsert(MemoVO mVO) {
        return mapper.MemoInsert(mVO);
    }

    @Override
    public MemoVO MemoSelect(int no) {
        return mapper.MemoSelect(no);
    }

    @Override
    public int CountMemo(String id) {
        return mapper.CountMemo(id);
    }

    @Override
    public List<MemoVO> MemoListSelect(String id, int month, int year){
        return mapper.MemoListSelect(id,month,year);
    }

    @Override
    public int MemoToAuth(CommunityVO bvo) {
        return mapper.MemoToAuth(bvo);
    }
}
