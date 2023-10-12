package com.team2.healthsns.service;

import com.team2.healthsns.vo.CommunityVO;
import com.team2.healthsns.vo.PagingVO;

import java.util.List;

public interface CommunityService {
    public int CommunityInsert(CommunityVO vo);
    public List<CommunityVO> CommunityPageList(PagingVO pVO);
    public int totalRecord(PagingVO pVO);
    public CommunityVO CommunitySelect(int no);
    public void hitCount(int no);
    public int CommunityUpdate(CommunityVO vo);
    public int CommunityDelete(int no);
}
