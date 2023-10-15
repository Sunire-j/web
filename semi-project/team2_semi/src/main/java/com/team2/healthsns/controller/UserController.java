package com.team2.healthsns.controller;

import com.team2.healthsns.mapper.UserMapper;
import com.team2.healthsns.service.UserService;
import com.team2.healthsns.vo.CommunityVO;
import com.team2.healthsns.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
        mav.setViewName("/user/userForm"); // JSP 파일 있는 폴더를 잡아줌 views까진 들어가진 상태.
        return mav;
    }

    @GetMapping("/user/idCheck")
    public ModelAndView idCheck(String userid) {
        System.out.println("userid->" + userid);

        // DB조회
        int result = service.idCheck(userid);

        ModelAndView mav = new ModelAndView();
        mav.addObject("result", result);
        mav.addObject("userid", userid);
        mav.setViewName("user/idCheck");

        return mav;
    }

    @PostMapping("/userFormOK")
    public ModelAndView userFormOK(UserVO vo) {
        ModelAndView mav = new ModelAndView();
        System.out.println(vo.getUserid()); // 임시

        if ("none".equals(vo.getPwd_q()) || vo.getPwd_q() == null) {
            mav.setViewName("redirect:signUpFail");
            return mav;
        }

        try {
            int result = service.userInsert(vo);

            if (result > 0) {
                mav.setViewName("redirect:/");
            } else {
                mav.setViewName("user/signUpFail");
            }
        } catch (Exception e) {
            e.printStackTrace();
            mav.setViewName("user/signUpFail");
        }
        return mav;

    }

    @RequestMapping("/user/login")
    public String login() {
        return "user/login";
    }

    @PostMapping("/user/loginOk")
    public ModelAndView loginOk(@RequestParam("userid") String userid,
                                @RequestParam("userpwd") String userpwd,
                                HttpSession session) {

        ModelAndView mav = new ModelAndView();

        UserVO logVo = service.loginSelect(userid, userpwd);
        System.out.println(logVo.getUserid());
        if (logVo != null) {

            session.setAttribute("logId", logVo.getUserid());
            session.setAttribute("logName", logVo.getUsername());
            session.setAttribute("logStatus", "Y");

            mav.setViewName("redirect:/home");
        } else {// 로그인 실패 -> 로그인 폼으로 이동
            mav.setViewName("redirect:login");
        }
        return mav;
    }


    @GetMapping("/user/userFind")
    public String userFind() {
        return "user/userFind";
    }

    @PostMapping("/user/findId") // 로 요청을 받음
    @ResponseBody // 응답을 전송함
    public String findId(String email) { // 메서드 findId 선언, email 파라미터를 입력받음. jsp에서 var params = "email=" + userEmailV;에서
        // 전달됨.
        // 서비스를 통해 이메일을 기반으로 아이디를 조회
        String foundId = service.findId(email); // 서비스 객체의 findID()메소드를 호출하여 아이디를 찾고 그 결과값을 foundId 변수에 저장함.
        return foundId; // 조회된 아이디를 반환.
    }


    //비밀번호 찾기
    @PostMapping("/user/checkUserInfo")
    @ResponseBody // 응답을 전송함
    public String checkUserInfo(@RequestParam("userid") String userid,
                                @RequestParam("email") String email,
                                @RequestParam("pwd_q") String pwd_q,
                                @RequestParam("pwd_a") String pwd_a) {

        String result = service.findPw(userid, email, pwd_q, pwd_a);
        return result;
    }


    @PostMapping("/user/changepwd")
    @ResponseBody
    public int changePwd(@RequestParam("changepwd") String pwd, @RequestParam("useridV") String userid) {
        int result = service.changePwd(pwd, userid);
        return result;
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
