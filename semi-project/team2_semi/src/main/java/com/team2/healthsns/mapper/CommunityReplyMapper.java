package com.team2.healthsns.mapper;

import com.team2.healthsns.vo.CommunityReplyVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommunityReplyMapper {
    public int replyInsert(CommunityReplyVO vo);
    public List<CommunityReplyVO> replySelect(int no);
    public int replyUpdate(String editcontent, int commentid);
    public int replyDelete(int replyno);
    public void SetNormalReplyTP(CommunityReplyVO vo);
}
