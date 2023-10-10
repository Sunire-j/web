package com.team2.healthsns.controller;

import com.team2.healthsns.service.MinihomeService;
import com.team2.healthsns.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MinihomeController {
    @Autowired
    MinihomeService service;

    @GetMapping("/minihome")
    public ModelAndView minihomeView(String id){
        ModelAndView mav = new ModelAndView();
        //왼쪽에 띄울 회원정보
        //1. 아이디, 유저네임, date, profile_img필요

        UserVO uservo = service.userSelect(id);


        //팔로워 팔로우 카운트(테이블에서 카운트만 세면 됨)
        //메모 수(카운트만 세면 됨)
        //투데이 수(카운트만 세면 됨)
        //오른쪽 달력에 띄울 달력정보 select
        // 방명록에 띄울 정보 select
        mav.addObject("ownerid",id);
        mav.addObject("uservo", uservo);
        mav.setViewName("/minihome/minihome");
        System.out.println(mav.getViewName());
        return mav;
    }
}
