package com.springboot.login.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.login.user.model.Crew_BoardVO;
import com.springboot.login.user.service.Crew_BoardService;

@CrossOrigin
@RestController
public class Crew_BoardController {

		
	@Autowired
	private Crew_BoardService crew_boardservice;
	
	@PostMapping(value = "/QnA")
	public void insertProcess(@RequestBody Crew_BoardVO crew_board) {
		
		crew_boardservice.save(crew_board);
	}

}
	
