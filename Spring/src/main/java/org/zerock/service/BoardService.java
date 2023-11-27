package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardService {

	public void register(BoardVO board);
	
	public BoardVO get(Long bno);
	
	public boolean modify(BoardVO board);
	
	public boolean remove(Long bno);
	
	// Page299 코딩할 때, 아래 1줄 소스는 주석 처리해 줍니다.
//	public List<BoardVO> getList();
	
	// Page299 : 페이징 처리가 적용되는 getList() 메서드 선언
	public List<BoardVO> getList(Criteria cri);
	
	// Page323 : 전체 데이터스를 구해주는 getTotal() 메서드 선언
	public int getTotal(Criteria cri);
	
}


