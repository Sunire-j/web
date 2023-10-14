package com.team2.healthsns.controller;
import com.team2.healthsns.service.CommunityReplyService;
import com.team2.healthsns.vo.CommunityReplyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/CommunityReply")
public class CommunityReplyController {
    @Autowired
    CommunityReplyService service;

    @PostMapping("/write")
    @ResponseBody
    public String replyWrite(CommunityReplyVO vo, HttpSession session){
        vo.setWriter((String) session.getAttribute("logId"));
        int result = service.replyInsert(vo);

        return String.valueOf(result);
    }

    //댓글 목록
    @GetMapping("/list")
    @ResponseBody
    public List<CommunityReplyVO> replyList(int no){
        List<CommunityReplyVO> replyList =service.replySelect(no);
        return replyList;
    }

    //댓글수정(DB)
    @PostMapping("/editOk")
    @ResponseBody
    public String replyEditOk(CommunityReplyVO vo){
        return service.replyUpdate(vo)+"";
    }

    //댓글삭제
    @GetMapping("/delete")
    @ResponseBody
    public String replyDelete(int replyno){
        return service.replyDelete(replyno)+"";
    }
}
