package com.team2.healthsns.service;

import com.team2.healthsns.mapper.CommunityMapper;
import com.team2.healthsns.vo.CommunityVO;
import com.team2.healthsns.vo.PagingVO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class CommunityServicempl implements CommunityService{
    @Inject
    CommunityMapper mapper;

    @Override
    public int CommunityInsert(CommunityVO vo) {
        return mapper.CommunityInsert(vo);
    }

    @Override
    public List<CommunityVO> CommunityPageList(PagingVO pVO) {
        return mapper.CommunityPageList(pVO);
    }

    @Override
    public int totalRecord(PagingVO pVO) {
        return mapper.totalRecord(pVO);
    }

    @Override
    public CommunityVO CommunitySelect(int no) {
        return mapper.CommunitySelect(no);
    }

    @Override
    public void hitCount(int no) {
        mapper.hitCount(no);
    }

    @Override
    public int CommunityUpdate(CommunityVO vo) {
        return mapper.CommunityUpdate(vo);
    }

    @Override
    public int CommunityDelete(int no) {
        return mapper.CommunityDelete(no);
    }
}
