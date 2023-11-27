package org.zerock.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SampleServiceTests {

	@Setter(onMethod_ = @Autowired)
	private SampleService service;
	
	@Test
	public void testClass() {
		log.info(service);
		log.info(service.getClass().getName());
	}
	
	@Test
	public void testAdd() throws Exception{
		log.info(service.doAdd("123", "456"));
	}
	
//	@Test
	public void testAddError() throws Exception{
		// doAdd() 메서드는 숫자로 변환이 가능한 문자열을 파라미터로 지정해야 하는데
		// 고의적으로 "ABC"와 같은 문자를 전달하여 예외처리가 발생하도록 했습니다.
		// 그래서 testAddError()의 JUnit 테스트 결과는 에러가 발생하면서 다음과 같이 나타납니다.
		// exception: java.lang.NumberFormatException: For input string: "ABC"
		log.info(service.doAdd("123", "ABC"));
	}
}


