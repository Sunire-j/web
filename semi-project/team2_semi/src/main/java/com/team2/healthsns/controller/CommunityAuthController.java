package com.team2.healthsns.controller;

import com.team2.healthsns.service.CommunityService;
import com.team2.healthsns.vo.CommunityVO;
import com.team2.healthsns.vo.PagingVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.StringTokenizer;

@Controller
public class CommunityAuthController {
    @Autowired
    CommunityService service;

    @GetMapping("/AuthCommunity/list")
    public ModelAndView CommunityListAuth(PagingVO pVO) {
        ModelAndView mav = new ModelAndView();
        pVO.setTotalRecord(service.totalRecordAuth(pVO));
        List<CommunityVO> list = service.CommunityPageListAuth(pVO);
        
        mav.addObject("list", list);
        mav.addObject("pVO", pVO);
        mav.setViewName("community/Community_Auth");
        return mav;
    }

    @GetMapping("/AuthCommunity/write")
    public String CommunityWrite(HttpSession session) {
        String logstatus = (String) session.getAttribute("LogStatus");
        if (!logstatus.equals("Y")) {
            return "/minihome/wrong";
        }
        return "/community/Community_Posting_Auth";
    }

    @PostMapping("/AuthCommunity/writeOk")
    public ModelAndView CommunityWriteOk(@RequestParam(value = "first-part", required = false) String firstpart,
            @RequestParam(value = "body-part", required = false) List<String> bodyparts,
            @RequestParam("subject") String subject,
            @RequestParam("content") String content,
            HttpSession session) {
        ModelAndView mav = new ModelAndView();
        String userid = (String) session.getAttribute("LogId");
        CommunityVO bVO = new CommunityVO();
        bVO.setUserid(userid);
        bVO.setBoard_cat("auth");
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

        int result = service.CommunityInsertAuth(bVO);

        if (result > 0) {
            mav.setViewName("redirect:/AuthCommunity/list");
        } else {
            mav.setViewName("/minihome/wrong");
        }

        return mav;
    }
  
  
    @GetMapping("/AuthCommunity/view")
    public ModelAndView CommunityView(int post_id, PagingVO pVO) {
        ModelAndView mav = new ModelAndView();
        service.hitCountAuth(post_id);
        CommunityVO vo = service.CommunitySelectAuth(post_id);
        mav.addObject("vo", vo);
        mav.addObject("pVO", pVO);
        mav.setViewName("/community/Community_Auth");
        return mav;
    }

    @GetMapping("/AuthCommunity/edit")
    public ModelAndView CommunityEdit(int post_id) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("vo", service.CommunitySelectAuth(post_id));
        mav.setViewName("community/Community_Edit_Auth");
        return mav;
    }

    @PostMapping("/AuthCommunity/editOk")
    public ModelAndView CommunityEditOk(CommunityVO vo) {
        ModelAndView mav = new ModelAndView();
        int result = service.CommunityUpdateAuth(vo);
        if (result > 0) {
            mav.setViewName("redirect:view?post_id=" + vo.getPost_id());
        } else {
            mav.setViewName("community/Community_Auth");
            mav.addObject("msg", "수정");
        }
        return mav;
    }

    @GetMapping("/AuthCommunity/delete")
    public ModelAndView CommunityDelete(int post_id) {
        ModelAndView mav = new ModelAndView();
        int result = service.CommunityDeleteAuth(post_id);
        if (result > 0) {
            mav.setViewName("redirect:list");
        } else {
            mav.setViewName("redirect:view?post_id=" + post_id);
        }
        return mav;
    }

}
