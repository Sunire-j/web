package com.team2.healthsns.controller;

import com.team2.healthsns.mapper.UserMapper;
import com.team2.healthsns.service.UserService;
import com.team2.healthsns.vo.CommunityVO;
import com.team2.healthsns.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService service;

    @PostMapping("/getuseremail")
    @ResponseBody
    public String getSessionEmail(HttpSession session) {
        //매개변수 logId를 이용해서 이메일만 select
        return service.GetSessionEmail((String) session.getAttribute("LogId"));
    }

    @GetMapping("/myPage")
    public ModelAndView MyPageView(HttpSession session) {
        ModelAndView mav = new ModelAndView();
        String userid = (String) session.getAttribute("LogId");
        String logStatus = (String) session.getAttribute("LogStatus");
        if (userid.isEmpty() || !logStatus.equals("Y")) {
            mav.setViewName("/minihome/wrong");
            return mav;
        }
        //비로그인 상태 제한 끝
        //유저정보 다 가져와야함
        UserVO uservo = service.UserSelectAll(userid);
        mav.addObject("uservo", uservo);
        mav.setViewName("/user/myPage");
        return mav;
    }


    //
    @GetMapping("/userForm")
    public ModelAndView userFormView() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/user/userForm"); //JSP 파일 있는 폴더를 잡아줌 views까진 들어가진 상태.
        return mav;
    }


    @PostMapping("/userFormOK")
    public ModelAndView userFormOK(UserVO uVO) {
        ModelAndView mav = new ModelAndView();
            /*
            try {
                int result = service.userInsert(vo);

                if (result > 0) {//회원가입 성공->로그인 폼
                    mav.setViewName("redirect:home");
                } else {//회원가입 실패-> 회원가입 폼 -> jsp-> history.back()
                    mav.setViewName("user/userForm");
                }
            }catch (Exception e){
                e.printStackTrace();
                mav.setViewName("user/userForm");
            }

             */
        return mav;

    }

    @PostMapping("/getfollowranking")
    @ResponseBody
    public List<UserVO> GetFollowRank() {
        List<UserVO> ranklist = service.GetFollowRanking();
        System.out.println(ranklist.get(0).getUsername());
        return ranklist;


    }

    @PostMapping("/getpostranking")
    @ResponseBody
    public List<CommunityVO> GetPostRank() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(new Date());
        return service.getTopPostsByDate(date);
    }


}
