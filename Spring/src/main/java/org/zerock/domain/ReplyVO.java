package org.zerock.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyVO {
	
	private Long rno;  // 댓글 번호(rno) 필드 선언
	private Long bno;  // 게시글 번호(bno) 필드 선언
	
	private String reply; // 댓글(reply) 필드 선언
	private String replyer;  // 댓글 등록자(replyer) 필드 선언
	private Date replyDate; // 댓글 등록일(replyDate) 필드 선언
	private Date updateDate; // 댓글 갱신일/수정일(updateDate) 필드 선언

}
