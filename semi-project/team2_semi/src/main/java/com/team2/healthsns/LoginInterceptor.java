package com.team2.healthsns;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String logStatus = (String) session.getAttribute("LogStatus");
        System.out.println(logStatus);
        if(logStatus==null || !logStatus.equals("Y")){
            response.sendRedirect(request.getContextPath()+"/");//로그인 매핑으로 바꿔야함
            System.out.println("false직전");
            return false;
        }

        System.out.println("true직전");
        return true;
    }
}
