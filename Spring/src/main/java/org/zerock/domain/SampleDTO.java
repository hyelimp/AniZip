package org.zerock.domain;

import lombok.Data;

// DTO(Data Transfer Object) 클래스
// = 계층간 데이터 교환을 하기 위해 사용하는 객체
@Data
public class SampleDTO {

	private String name;
	private int age;	
	
}
