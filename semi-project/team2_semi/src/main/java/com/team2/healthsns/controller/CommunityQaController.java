package com.team2.healthsns.controller;

import com.team2.healthsns.service.CommunityService;
import com.team2.healthsns.vo.CommunityVO;
import com.team2.healthsns.vo.PagingVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CommunityQaController {
    @Autowired
    CommunityService service;

    @GetMapping("/QaCommunity/list")
    public ModelAndView CommunityListQa(PagingVO pVO) {
        ModelAndView mav = new ModelAndView();
        pVO.setTotalRecord(service.totalRecordQa(pVO));
        List<CommunityVO> list = service.CommunityPageListQa(pVO);
        mav.addObject("list", list);
        mav.addObject("pVO", pVO);
        mav.setViewName("community/Community_Qa");
        return mav;
    }

    // 아래로 조석훈이 수정
    @GetMapping("/QaCommunity/write")
    public String CommunityWrite(HttpSession session) {
        String logstatus = (String) session.getAttribute("LogStatus");
        if (!logstatus.equals("Y")) {
            return "/minihome/wrong";
        }
        return "/community/Community_Posting_Qa";
    }

    @PostMapping("/QaCommunity/writeOk")
    public ModelAndView CommunityWriteOk(@RequestParam(value = "first-part", required = false) String firstpart,
            @RequestParam(value = "body-part", required = false) List<String> bodyparts,
            @RequestParam("subject") String subject,
            @RequestParam("content") String content,
            HttpSession session) {
        ModelAndView mav = new ModelAndView();
        String userid = (String) session.getAttribute("LogId");
        CommunityVO bVO = new CommunityVO();
        bVO.setUserid(userid);
        bVO.setBoard_cat("qa");
        bVO.setTitle(subject);
        bVO.setContent(content);
        if (firstpart != null) {
            bVO.setCat(firstpart);
        }
        if (bodyparts != null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bodyparts.size(); i++) {
                sb.append(bodyparts.get(i)).append("/");
            }
            bVO.setBodypart(String.valueOf(sb));
        }

        int result = service.CommunityInsertQa(bVO);

        if (result > 0) {
            mav.setViewName("redirect:/QaCommunity/list");
        } else {
            mav.setViewName("/minihome/wrong");
        }

        return mav;
    }

    @GetMapping("/QaCommunity/view")
    public ModelAndView CommunityView(int post_id, PagingVO pVO) {
        ModelAndView mav = new ModelAndView();
        service.hitCountQa(post_id);
        CommunityVO vo = service.CommunitySelectQa(post_id);
        mav.addObject("vo", vo);
        mav.addObject("pVO", pVO);
        mav.setViewName("/community/Community_Qa");
        return mav;
    }

    @GetMapping("/QaCommunity/edit")
    public ModelAndView CommunityEdit(int post_id) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("vo", service.CommunitySelectQa(post_id));
        mav.setViewName("community/Community_Edit_Qa");
        return mav;
    }

    @PostMapping("/QaCommunity/editOk")
    public ModelAndView CommunityEditOk(CommunityVO vo) {
        ModelAndView mav = new ModelAndView();
        int result = service.CommunityUpdateQa(vo);
        if (result > 0) {
            mav.setViewName("redirect:view?no=" + vo.getPost_id());
        } else {
            mav.setViewName("community/community_Qa");
            mav.addObject("msg", "수정");
        }
        return mav;
    }

    @GetMapping("/QaCommunity/delete")
    public ModelAndView CommunityDelete(int post_id) {
        ModelAndView mav = new ModelAndView();
        int result = service.CommunityDeleteQa(post_id);
        if (result > 0) {
            mav.setViewName("redirect:list");
        } else {
            mav.setViewName("redirect:view?no=" + post_id);
        }
        return mav;
    }
}
