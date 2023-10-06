package kr.ch10.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="USER5")
public class User5Entity {
	
	@Id
	private String id;
	private String name;
	private String gender;
	private int age;
	private String addr;
	
}