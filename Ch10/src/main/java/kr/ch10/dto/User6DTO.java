package kr.ch10.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User6DTO {
	
	private int seq;
	private String name;
	private String gender;
	private String age;
	private String addr;
	
}