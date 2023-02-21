package org.kh.spring.member.store;

import java.util.List;

import org.kh.spring.member.domain.Member;

public interface MemberStore {

	/**
	 * 회원 로그인 Store
	 * @param member
	 * @return Member
	 */
	public Member checkMemberLogin(Member member);
	
	
	/**
	 * 회원 목록 조회 Store
	 * @return 
	 */
	public List<Member> selectMembers();
	
	
	/**
	 * 아이디로 회원 조회(상세조회) Store
	 * @param memberId
	 * @return Member
	 */
	public Member selectOneById(String memberId);
}
