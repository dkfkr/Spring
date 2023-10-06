package kr.ch10.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="USER4")
public class User4Entity {
	
	@Id
	private String id;
	private String name;
	private String gender;
	private String age;
	private String addr;
	
}