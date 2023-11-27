package com.springboot.login.user.service;

import com.springboot.login.user.model.MemberVO;

public interface MemberService {

	/**
	 * 아이디, 패스워드로 회원 조회 처리함
	 * @param memberVO
	 * @throws Exception
	 */
	MemberVO selectMemberByIdByPw(MemberVO memberVO) throws Exception;	
	
}
