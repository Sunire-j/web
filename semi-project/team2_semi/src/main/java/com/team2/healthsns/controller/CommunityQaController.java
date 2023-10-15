package com.team2.healthsns.controller;

import com.team2.healthsns.service.CommunityService;
import com.team2.healthsns.vo.CommunityVO;
import com.team2.healthsns.vo.PagingVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import com.team2.healthsns.util.UriUtil;
import java.util.StringTokenizer;

@Controller
public class CommunityQaController {
    @Autowired
    CommunityService service;

    @RequestMapping(value = "/QaCommunity/list", method = RequestMethod.GET)
    public String list(Model model, @ModelAttribute("pVO") PagingVO pVO) {
        try {
            // Fetch the records based on the parameters in pVO
            pVO.setTotalRecord(service.totalRecordQa(pVO));
            
            List<CommunityVO> communityItems = service.CommunityPageListQa(pVO);
            model.addAttribute("list", communityItems);
            
            // Add all the search and sort parameters to the model to be used in the frontend
            model.addAttribute("page", pVO.getNowPage());
            model.addAttribute("searchKey", pVO.getSearchKey());
            model.addAttribute("searchWord", pVO.getSearchWord());
            model.addAttribute("category", pVO.getCategory());
            model.addAttribute("postSort", pVO.getPostSort());
            
            // Add the generated URI for search and sort to the model
            model.addAttribute("uri", getUri(pVO));
            
        } catch (Exception e) {
            // Optionally: Log the exception or handle it accordingly
            e.printStackTrace();
        }
        System.out.println("PostSort value: " + pVO.getPostSort());
        return "community/Community_Qa";
    }
    
    private String getUri(PagingVO pVO) {
        int page = pVO.getNowPage();
        String searchType = pVO.getSearchKey();
        String keyword = pVO.getSearchWord();
        String category = pVO.getCategory(); // Fetch category info
        String postSort = pVO.getPostSort(); // Fetch sort option

        return UriUtil.makeSearch(page, searchType, keyword, category, postSort);
    }

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
