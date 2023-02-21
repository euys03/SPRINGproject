package org.kh.spring.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kh.spring.member.domain.Member;
import org.kh.spring.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService mService;
	
	
	/* 회원 로그인 */
	//  /member/login.do url이 들어왔을 때 연결 RequestMapping
	@RequestMapping(value="/member/login.do", method=RequestMethod.POST)
	public String memberLogin(HttpServletRequest request, Model model) {
		try {
			String memberId = request.getParameter("member-id");
			String memberPw = request.getParameter("member-pw");
			Member mParam = new Member(memberId, memberPw);
			Member member = mService.checkMemberLogin(mParam);
			
			if(member != null) {
				// 성공하면 성공페이지
//			request.setAttribute("msg", "성공!");
				//model.addAttribute("msg", "성공");
//			request.getRequestDispatcher("/WEB-INF/views/common/success.jsp");
				//return "common/success";
				
				// 성공하면 세션에 정보 저장
				HttpSession session = request.getSession();
				session.setAttribute("loginUser", member);
				return "redirect:/home.do";
			}else {
				// 실패하면 실패페이지
				model.addAttribute("msg", "실패");
				return "common/error";
			}
			
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "common/error";
		}
	}
	
	@RequestMapping(value="/member/logout.do", method=RequestMethod.GET)
	// 로그아웃 -> 세션 파괴
	public String memberLogout(HttpServletRequest request, HttpServletResponse response) {
		//response.sendRedirect("/index.jsp");
		HttpSession session = request.getSession();
		if(session != null) {
			session.invalidate();
		}
		return "redirect:/index.jsp";
	}
	
	
	
	/* 회원 목록 조회 */
	//  /member/list.do RequestMapping에 의해 연결
	@RequestMapping(value="/member/list.do", method=RequestMethod.GET)
	public String printMembers(Model model) {
		try {
			List<Member> mList = mService.selectMembers();
			if(!mList.isEmpty()) {
				model.addAttribute("mList", mList);
				return "member/list";
			}else {
				model.addAttribute("msg", "데이터가 존재하지 않습니다.");
				return "common/error";
			}
		} catch (Exception e) {
			model.addAttribute("msg", e.getMessage());
			return "common/error";
		}
	}
	
	
	/* 아이디로 회원 조회(상세조회) */
	//  /member/detail.do
	@RequestMapping(value="/member/detail.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String printOneById(HttpServletRequest request, Model model) {
		String memberId = request.getParameter("memberId");
		Member member = mService.selectOneById(memberId);
		if(member != null) {
			model.addAttribute("member", member);
			return "member/detail";
		}else {
			model.addAttribute("msg", "회원 조회 실패");
			return "common/error";
		}
	}
}
