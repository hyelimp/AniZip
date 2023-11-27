package org.zerock.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.zerock.domain.Ticket;

import com.google.gson.Gson;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

// 스프링의 테스트 기능을 활용하면 개발 당시에 Tomcat(WAS)을 실행하지 않고도
// 스프링과 웹 URL을 테스트할 수 있습니다. WAS를 실행하지 않기 위해서는 약간의 추가적인 코드가
// 필요하지만 반복적으로 서버를 실행하고 화면에 입력하고, 오류를 수정하는 단계를 줄여줄 수 있기
// 때문에 Controller를 테스트할 때는 한번쯤 고려해 볼 필요가 있습니다.
@RunWith(SpringJUnit4ClassRunner.class)
// Test for Controller : @WebAppConfiguration은 Servlet의 ServletContext를
// 이용하기 위해서 사용하며, 스프링에서는 WebApplicationContext를 이용하기 위해 선언합니다.
@WebAppConfiguration
@ContextConfiguration({
 "file:src/main/webapp/WEB-INF/spring/root-context.xml",
 "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Log4j
public class SampleControllerTests {

	@Setter(onMethod_ = {@Autowired})
	private WebApplicationContext ctx;
	// MockMvc는 '가짜 mvc'라고 생각하시면 됩니다. 가짜로 URL과 파라미터 등을 브라우저에서
	// 사용하는 것처럼 만들어서 Controller를 실행해 볼 수 있습니다.
	private MockMvc mockMvc;
	// @Before 적용된 메서드는 모든 테스트 전에 매번 실행되는 메서드가 됩니다.
	// @Before 어노테이션이 적용된 setup()에서는 import할 때 JUnit을 사용해야 합니다.
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void testConvert() throws Exception {
		
		Ticket ticket = new Ticket();
		ticket.setTno(230910);
		ticket.setOwner("Admin");
		ticket.setGrade("AAA");
		
		// Gson 라이브러리는 Java의 객체(ticket)를 JSON 문자열로 변환하기 위해 사용합니다!
		String jsonStr = new Gson().toJson(ticket);
		
		log.info(jsonStr);
		
		mockMvc.perform(post("/sample/ticket")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonStr))
				.andExpect(status().is(200));		
	}
}

