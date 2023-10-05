package ch06.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import ch06.dao.User4DAO;
import ch06.dto.User4DTO;

@Repository
public class User4Service {
	
	@Autowired
	private User4DAO dao;
	
	public void insertUser4(User4DTO dto) {
		dao.insertUser4(dto);
	}
	
	public User4DTO selectUser4(String uid) {
		return dao.selectUser4(uid);
	}
	
	public List<User4DTO> selectUser4s() {
		return dao.selectUser4s();
	}
	
	public void updateUser4(User4DTO dto) {
		dao.updateUser4(dto);
	}
	
	public void deleteUser4(String uid) {
		dao.deleteUser4(uid);
	}
}
