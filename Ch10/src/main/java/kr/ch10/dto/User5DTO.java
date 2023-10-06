package kr.ch10.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User5DTO {
	
	private String id;
	private String name;
	private String gender;
	private int age;
	private String addr;
	
}