package com.team2.healthsns.service;

import com.team2.healthsns.mapper.CommunityReplyMapper;
import com.team2.healthsns.vo.CommunityReplyVO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class CommunityReplyServicempl implements CommunityReplyService{
    @Inject
    CommunityReplyMapper mapper;

    @Override
    public int replyInsert(CommunityReplyVO vo) {
        return mapper.replyInsert(vo);
    }

    @Override
    public List<CommunityReplyVO> replySelect(int no) {
        return mapper.replySelect(no);
    }

    @Override
    public int replyUpdate(String editcontent, int commentid){
        return mapper.replyUpdate(editcontent,commentid);
    }

    @Override
    public int replyDelete(int replyno) {
        return mapper.replyDelete(replyno);
    }

    @Override
    public void SetNormalReplyTP(CommunityReplyVO vo) {
        mapper.SetNormalReplyTP(vo);
    }
}
