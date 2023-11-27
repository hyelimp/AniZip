package com.springboot.login.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.login.user.model.Crew_BoardVO;


public interface Crew_BoardMapper extends JpaRepository<Crew_BoardVO, String> {


	Crew_BoardVO save(Crew_BoardVO crew_Board);


}

