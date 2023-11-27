package org.zerock.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {

	@Setter(onMethod_ = {@Autowired})
	private BoardService service;
	
	@Test
	public void testExit() {
		log.info(service);
		assertNotNull(service);
	}
	
	// 등록(register) 작업의 기능 구현과 테스트
	@Test
	public void testRegister() {
		BoardVO board = new BoardVO();
		board.setTitle("BoardServiceTests에서 생성한 새로운 글 제목");
		board.setContent("새로운 글 내용");
		board.setWriter("퐁키");
		
		service.register(board);
		log.info("BoardServiceTests에서 생성된 게시물의 번호 : " + board.getBno());
	}

	// 글목록(리스트) 작업의 기능 구현과 테스트
	@Test
	public void testGetList() {
		// Page300 소스 코딩할 때, 아래 1줄 소스는 주석 처리해 줍니다.
//		service.getList().forEach(board -> log.info(board));
		// Page300 : 페이징 매개변수가 적용된 getList() 메서드 테스트를 합니다.
		service.getList(new Criteria(2, 10)).forEach(board -> log.info(board));
	}
	
	// 특정 글 조회 작업의 기능 구현과 테스트
	@Test
	public void testGet() {
		// 1번 글의 상세 정보를 로그 정보로 표시해 줍니다.
		log.info(service.get(1L));
	}

	
	// 글 수정 기능 구현과 테스트
	@Test
	public void testModify() {
		// testModify()의 경우, 특정한 게시글(여개서는 1번글)을 먼저 조회하고,
		BoardVO board = service.get(1L); // 1번 글 수정 처리
		if (board == null) {
			return;
		}
		// 아래의 소스 코드에서 title 값을 수정한 후에, 이를 업데이트 처리 합니다.
		board.setTitle("1번 글의 제목을 수정합니다!");
		log.info("MODIFY RESULT : " + service.modify(board));
	}

	// 글 삭제 기능 구현과 테스트
	@Test
	public void testRemove() {
		// 게시물 번호의 존재 여부를 확인하고 테스트를 진행 처리함.
		// testDelete()의 경우, 해당 게시물이 존재할 때 true를 반환하는 것을 확인합니다.
		log.info("REMOVE RESULT : " + service.remove(44L)); // 44번 게시글 삭제 처리
	}
	
	


}
