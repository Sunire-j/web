package com.team2.healthsns.mapper;

import com.team2.healthsns.vo.CommunityVO;
import com.team2.healthsns.vo.PagingVO;

import java.util.List;

public interface CommunityMapper {
    public int CommunityInsert(CommunityVO vo);
    public List<CommunityVO> CommunityPageList(PagingVO pVO);//page에 해당하는 레코드 선택
    public int totalRecord(PagingVO pVO);
    public CommunityVO CommunitySelect(int no);
    //조회수 증가
    public void hitCount(int no);
    //게시판 수정
    public int CommunityUpdate(CommunityVO vo);
    //게시글 삭제
    public int CommunityDelete(int no);
}
