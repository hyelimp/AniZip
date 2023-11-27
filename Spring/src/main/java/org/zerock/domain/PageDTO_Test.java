package org.zerock.domain;

public class PageDTO_Test {

	public static void main(String[] args) {
		
		// 12페이지의 경우 : Math.ceil(1.2) = 12
		System.out.println(12/10.0); // cri.getPageNum()를 12으로 가정함 : 1.2
		System.out.println(Math.ceil(1.2)); // 2.0
		System.out.println((Math.ceil(1.2)*10)); // 2.0 * 10 = 20.0
		System.out.println((int)(Math.ceil(1.2)*10)); // 20
		int endPage = (int)(Math.ceil(1.2)*10);
		int startPage = endPage - 9;
		System.out.println(startPage); // 11
		System.out.println(endPage); // 20
		
		// 전체 데이터 수 필드(total)를 120개, 그리고, 10개씩 데이터를 보여준다고 가정합니다. 
		int realEnd = (int) Math.ceil(((120* 1.0) / 10));
		System.out.println(realEnd); // 12
		if(realEnd < endPage) {
			endPage = realEnd; // endPage에 realEnd(12page)를 대입 처리합니다.
		}
		System.out.println(endPage + ", " + realEnd); // 12, 12
		
//		boolean prev = startPage > 1 : startPage가 11이라고 가정함
		boolean prev = 11 > 1; // prev 는 true 상태(prev 가 있음)
//		boolean next = endPage < realEnd : endPage가 20, realEnd는 2라고 가정함
		boolean next = 20 < 12; // next 는 false 상태(next 가 없음)		
	}
}
