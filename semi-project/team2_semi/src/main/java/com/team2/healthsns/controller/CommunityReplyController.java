package com.team2.healthsns.controller;
import com.team2.healthsns.service.CommunityReplyService;
import com.team2.healthsns.vo.CommunityReplyVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;

@Controller
@RequestMapping("/CommunityReply")
public class CommunityReplyController {
    @Autowired
    CommunityReplyService service;

    @PostMapping("/write")
    @ResponseBody
    public String replyWrite(CommunityReplyVO vo, HttpSession session){
        vo.setWriter((String) session.getAttribute("LogId"));
        int result = service.replyInsert(vo);
        if(vo.getDepth()==0){
            service.SetNormalReplyTP(vo); //depth가 0이면 target_parent를 자신의 comment_id로 설정하는

        }
        return String.valueOf(result);
    }

    //댓글 목록
    @PostMapping("/list")
    @ResponseBody
    public List<CommunityReplyVO> replyList(int no){
        List<CommunityReplyVO> replyList =service.replySelect(no);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

       for(CommunityReplyVO rvo : replyList){
           LocalDateTime writeDate = LocalDateTime.parse(rvo.getWrite_date(), dtf);
           if(writeDate.getYear() != now.getYear()){
               rvo.setWrite_date(writeDate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));
           } else if(writeDate.getMonthValue() != now.getMonthValue()){
               rvo.setWrite_date(writeDate.format(DateTimeFormatter.ofPattern("MM/dd")));
           } else if(writeDate.getDayOfMonth() != now.getDayOfMonth()){
               rvo.setWrite_date(writeDate.format(DateTimeFormatter.ofPattern("MM/dd")));
           } else {
               rvo.setWrite_date(writeDate.format(DateTimeFormatter.ofPattern("HH:mm")));
           }
       }
        return replyList;
    }

    //댓글수정(DB)
    @PostMapping("/editOk")
    @ResponseBody
    public int replyEditOk(String editcontent, int commentid){
        return service.replyUpdate(editcontent, commentid);
    }

    //댓글삭제
    @PostMapping("/delete")
    @ResponseBody
    public int replyDelete(int commentid){
        return service.replyDelete(commentid);
    }
}
