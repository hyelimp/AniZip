package com.springboot.login.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.login.user.model.MemberVO;
import com.springboot.login.user.repository.MemberDAO;
import com.springboot.login.user.service.MemberService;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO memberDAO;

	/**
	 * 아이디, 패스워드로 회원 조회 처리함
	 * @param memberVO
	 * @throws Exception
	 */
	@Override
	public MemberVO selectMemberByIdByPw(MemberVO memberVO) throws Exception {
		MemberVO resultVO = memberDAO.findByMemberIdAndMemberPw(memberVO.getMemberId(), memberVO.getMemberPw());
		return resultVO;
	}		
}

