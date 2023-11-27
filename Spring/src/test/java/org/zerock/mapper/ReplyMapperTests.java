package org.zerock.mapper;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

// Ctrl + Shift + O : import 자동 정리

//@RunWith 어노테이션은 현재 테스트 코드가 스프링을 실행하는 역할을 할 것이이라는 것을 나타냅니다.
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration 어노테이션은 속성값의 문자열 설정으로 지정된 클래스나 문자열을 이용해서
//필요한 객체들을 스프링 내에 객체로 등록하게 됩니다(이것을 스프링의 빈으로 등록된다고 표현합니다)
//이때, SpringMVC 프로젝트 생성시 자동으로 생성된 root-context.xml 경로 지정을 할 수도 있으며,
//보통 문자열은 'classpath:'나 'file:'을 이용할 수 있습니다.
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
//@Log4j 어노테이션은 Lombok을 이용해서 로그를 기록하는 Logger를 변수로 생성합니다.
//별도의 Logger 객체의 선언이 없이도 Log4j 라이브러리와 설정이 존재한다면 바로 사용이 가능합니다.
@Log4j
public class ReplyMapperTests {

	// 테스트 하기 전에 테스트를 수행할 bno(기존 작성 게시물 번호)가 
	// 있는지(존재하는지) 확인하고, 기존 작성 게시물 번호 bno에 댓글을 
	// 추가 등록합니다. 그렇기 때문에 기존 작성 게시물 번호를
	// 배열 변수 넣고 테스트 하도록 합니다.
	private Long[] bnoArr = {721002L, 721001L, 720980L, 720973L, 720972L};
	
	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;
	
	@Test
	public void testMapper() {
		log.info(mapper);
	}
	
	@Test
	public void testCreate() {
		IntStream.rangeClosed(1, 10).forEach(i -> {
			ReplyVO vo = new ReplyVO();
			
			vo.setBno(bnoArr[i % 5]); // 게시글 번호 처리
			vo.setReply("댓글 테스트 " + i);
			vo.setReplyer("replyer" + i);
			
			mapper.insert(vo);
		});
	}
	
	@Test
	public void testRead() {
		Long targetRno = 12L;
		
		ReplyVO vo = mapper.read(targetRno);
		
		log.info(vo);
	}
	
	@Test
	public void testDelete() {
		Long targetRno = 13L;
		mapper.delete(targetRno);
	}
	
	// 특정 댓글 읽기 쿼리문을 실행해서 확인해 봅니다.
	// select * from tbl_reply where rno = 14;
	@Test
	public void testUpdate() {
		Long targetRno = 14L;
		
		ReplyVO vo = mapper.read(targetRno);
		
		vo.setReply("＠＠＠~댓글 수정 테스트! 와우~ ^^");
		
		int count = mapper.update(vo);
		
		log.info("UPDATE COUNT = " + count);
	}
	
	@Test
	public void testList() {
		Criteria cri = new Criteria();
		List<ReplyVO> replies = mapper.getListWithPaging(cri, bnoArr[3]);
		replies.forEach(reply -> log.info(reply));
	}	
	
	@Test
	public void testList2() {
		Criteria cri = new Criteria(2, 10);
		// 721001 : 대글이 21개 있는 게시글 번호(bno)값을 활용합니다.
		List<ReplyVO> replies = mapper.getListWithPaging(cri, 721001L);
		replies.forEach(reply -> log.info(reply));
	}
	
}

