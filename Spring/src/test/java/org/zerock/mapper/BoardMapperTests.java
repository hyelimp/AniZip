package org.zerock.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

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
public class BoardMapperTests {

	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	@Test
	public void testGetList() {		
		mapper.getList().forEach(board -> log.info(board));
	}
	
	@Test
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 글 제목!");
		board.setContent("새로 작성하는 글 내용!");
		board.setWriter("김희선");
		
		mapper.insert(board);
		log.info(board);
	}
	
	@Test
	public void testInsertSelectKey() {
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 글 select key 제목");
		board.setContent("새로 작성하는 내용 select key 내용");
		board.setWriter("김연아");
		
		mapper.insertSelectKey(board);
		log.info(board);
	}
	
	@Test
	public void testRead() {
		// 이번에 testRead() 메서드의 테스트 확인은 "기존에 있는 DB 데이터 정보 bno값"을 활용합니다.
		BoardVO board = mapper.read(3L);
		log.info(board);		
	}
	
	@Test
	public void testDelete() {
		log.info("삭제 처리 리턴값 DELETE COUNT : " + mapper.delete(21L));
	}
	
	@Test
	public void testUpdate() {
		BoardVO board = new BoardVO();
		// 수정하기 위한 게시글번호(bno)가 있는 DB 데이터를 활용합니다!
		board.setBno(5L);
		board.setTitle("5번글 testUpdate() 메서드 활용 제목 수정 와우!");
		board.setContent("5번글 testUpdate() 메서드 활용 내용 수정 와우!");
		board.setWriter("고윤정");
		
		int count = mapper.update(board);
		log.info("UPDATE COUNT : " + count);
	}
	
	@Test
	public void testPaging() {
	
		Criteria cri = new Criteria();
		
		// Page297 : 10개씩 3페이지 출력 내용을 확인해 봅니다!
		cri.setPageNum(3); // 3페이지의
		cri.setAmount(10); // 10개 데이터를
		
		List<BoardVO> list = mapper.getListWithPaging(cri); // list에 담아서 보여주게 합니다!
		
		list.forEach(board -> log.info(board));
	}
	
	@Test
	public void testSearch() {
		Criteria cri = new Criteria();
		cri.setKeyword("Test");
		cri.setType("TC");
		List<BoardVO> list = mapper.getListWithPaging(cri);
		list.forEach(board -> log.info(board));
	}
}
