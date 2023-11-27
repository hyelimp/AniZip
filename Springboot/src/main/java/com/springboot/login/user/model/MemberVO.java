package com.springboot.login.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name = "app_user")
public class MemberVO {

	@Id
	@Column(name = "user_id")
	private String memberId;
	@Column(name = "user_password")
	private String memberPw;
	@Column(name = "user_name")
	private String memberName;	
}
