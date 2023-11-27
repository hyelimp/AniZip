package com.springboot.login.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.login.user.model.MemberVO;

// SPRINGBOOT_LOGIN 테이블 Repository
public interface MemberDAO extends JpaRepository<MemberVO, Integer> {

	// 회원가입여부를 확인하기 위한 MemberId, MemberPw로 단건 조회를 처리합니다.
	MemberVO findByMemberIdAndMemberPw(String memberId, String memberPw);
}
