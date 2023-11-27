package com.springboot.login.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "CREW_BOARD")
public class Crew_BoardVO {

    @Id
    @Column(name = "qnatitle") 
    private String qnatitle; 

    @Column(name = "qnacontent")
    private String qnacontent;

    @Column(name = "qnawriter")
    private String qnawriter;

    @Column(name = "qnanumber")
    private String qnanumber; 
}