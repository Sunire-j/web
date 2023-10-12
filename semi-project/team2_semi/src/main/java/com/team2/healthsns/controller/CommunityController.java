package com.team2.healthsns.controller;

import com.team2.healthsns.service.CommunityService;
import com.team2.healthsns.vo.CommunityVO;
import com.team2.healthsns.vo.PagingVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CommunityController {
    @Autowired
    CommunityService service;

    //게시판
    @GetMapping("/Community/list")
    public ModelAndView CommunityList(PagingVO pVO) {
        ModelAndView mav = new ModelAndView();
        //총레코드 수
        pVO.setTotalRecord(service.totalRecord(pVO));
        //DB선택(page, 검색)
        List<CommunityVO> list = service.CommunityPageList(pVO);
        mav.addObject("list",list);
        mav.addObject("pVO",pVO);
        mav.setViewName("Community/CommunityList");

        return mav;
    }

    //글쓰기폼
    @GetMapping("/Community/write")
    public String CommunityWrite() {
        return "/Community/CommunityWrite";
    }

    //글등록(DB)
    @PostMapping("/Community/writeOk")
    public ModelAndView CommunityWriteOk(CommunityVO vo, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        //subject, content -> vo에 request
        //request->session
        vo.setIp(request.getRemoteAddr());
        vo.setUserid((String) request.getSession().getAttribute("logId"));

        try {
            int result = service.CommunityInsert(vo);
            if (result > 0) {
                mav.setViewName("redirect:list");
            } else {
                mav.setViewName("Community/CommunityResult");
                mav.addObject("msg","등록");
            }
        } catch (Exception e) {
            e.printStackTrace();
            mav.setViewName("Community/CommunityResult");
            mav.addObject("msg","등록");
        }
        return mav;
    }

    //글내용보기
    @GetMapping("/Community/view")
    public ModelAndView CommunityView(int no, PagingVO pVO){
        ModelAndView mav = new ModelAndView();
        service.hitCount(no);
        CommunityVO vo = service.CommunitySelect(no);


        mav.addObject("vo",vo);
        mav.addObject("pVO", pVO);
        mav.setViewName("/Community/CommunityView");
        return mav;

    }

    //글수정
    @GetMapping("/Community/edit")
    public ModelAndView CommunityEdit(int no){
        ModelAndView mav = new ModelAndView();
        mav.addObject("vo", service.CommunitySelect(no));
        mav.setViewName("Community/CommunityEdit");
        return mav;
    }

    @PostMapping("/Community/editOk")
    public ModelAndView CommunityEditOk(CommunityVO vo){
        ModelAndView mav = new ModelAndView();
        try {

            int result = service.CommunityUpdate(vo);
            if (result > 0) {
                mav.setViewName("redirect:view?no="+vo.getPost_id());
            } else {
                mav.setViewName("Community/CommunityResult");
                mav.addObject("msg", "수정");
            }
        }catch(Exception e){
            mav.setViewName("Community/CommunityResult");
            mav.addObject("msg", "수정");
        }
        return mav;
    }

    //글삭제
    @GetMapping("/Community/delete")
    public ModelAndView CommunityDelete(int no){
        ModelAndView mav = new ModelAndView();
        try {
            int result = service.CommunityDelete(no);
            if (result > 0) {
                mav.setViewName("redirect:list");
            } else {
                mav.setViewName("redirect:view?no="+no);
            }
        }catch (Exception e){
            mav.setViewName("redirect:view?no="+no);
        }
        return mav;
    }
}

