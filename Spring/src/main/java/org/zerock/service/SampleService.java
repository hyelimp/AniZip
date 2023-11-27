package org.zerock.service;

// AOP 예제 : 서비스 계층의 메서드 호출 시 모든 파라미터들을 로그로 기록하는 예시 입니다.

public interface SampleService {

	public Integer doAdd(String str1, String str2) throws Exception;
	
}
