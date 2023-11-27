package com.springboot.login.user.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.login.user.model.Crew_BoardVO;
import com.springboot.login.user.repository.Crew_BoardMapper;
import com.springboot.login.user.service.Crew_BoardService;



@Service
public class Crew_BoardServiceImpl implements Crew_BoardService {

    @Autowired
    private Crew_BoardMapper dao;
	

	public Crew_BoardVO save(Crew_BoardVO corew_board) {
		return dao.save(corew_board);
	}
}