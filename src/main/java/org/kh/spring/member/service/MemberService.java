package org.kh.spring.member.service;

import java.util.List;

import org.kh.spring.member.domain.Member;

public interface MemberService {

	/**
	 * 회원 로그인 Service
	 * @param member
	 * @return Member
	 */
	public Member checkMemberLogin(Member member);

	
	/**
	 * 회원 목록 조회 Service
	 * @return 
	 */
	public List<Member> selectMembers();


	/**
	 * 아이디로 회원 조회(상세조회) Service
	 * @param memberId
	 * @return Member
	 */
	public Member selectOneById(String memberId);
}
