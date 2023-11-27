package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service  // 계층 구조상 주로 비즈니스 영역을 담당하는 객체임을 표시하기 위해 사용함.
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {


		// @Setter(onMethod_ = @Autowired)
		// Spring 4.3 이상에서는 단일 파라미터를 받는 생성자의 경우 자동 처리
		// (파라미터를 자동으로 주입할 수 있음. 즉, 위에 @Setter 구문 안써도 됨)
		private BoardMapper mapper;

		@Override
		public void register(BoardVO board) {
			log.info("register 게시글등록 서비스 실행!" + board);
			mapper.insertSelectKey(board);
		}

		// 특정 글 상세조회 작업의 기능 구현
		@Override
		public BoardVO get(Long bno) {
			log.info("get... 특정 글 내용을 조회 합니다!" + bno);
			return mapper.read(bno);
		}

		@Override
		public boolean modify(BoardVO board) {
			log.info("modify... 게시글을 수정 처리 합니다!" + board);
			// 정상적으로 수정이 이루어지면 1이라는 값이 반환되기 때문에
			// '==' 연산자를 이용해서 true/false를 처리할 수 있습니다.
			return mapper.update(board) == 1;
		}

		@Override
		public boolean remove(Long bno) {
			log.info("remove... 게시글을 삭제 처리 합니다!" + bno);
			// 정상적으로 삭제가 이루어지면 1이라는 값이 반환되기 때문에
			// '==' 연산자를 이용해서 true/false를 처리할 수 있습니다.
			return mapper.delete(bno) == 1;
		}

		// 게시글목록(리스트) 작업의 기능 구현
		// Page299 소스 코딩할 때, 아래 5줄 소스는 주석 처리해 줍니다.
//		@Override
//		public List<BoardVO> getList() {
//			log.info("getList... 목록 리스트 정보를 보여줍니다!");
//			return mapper.getList();
//		}

		// Page299 : 페이징 매개변수가 적용된 getList() 메서드 선언
		@Override
		public List<BoardVO> getList(Criteria cri) {
			log.info("get List with criteria : " + cri);
			return mapper.getListWithPaging(cri);
		}

		// 전체 데이터수를 구해주는 getTotal() 메서드 선언
		@Override
		public int getTotal(Criteria cri) {
			log.info("get total count : 전체 데이터 수를 구해줍니다!");
			return mapper.getTotalCount(cri);
		}
}


