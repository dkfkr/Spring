package kr.ch10.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ch10.entity.User5Entity;
import kr.ch10.repository.User5Repository;

@Service
public class User5Service {
	
	@Autowired
	private User5Repository repo;
	
	public void insertUser5(User5Entity user5) {
		repo.save(user5);
	}
	public User5Entity selectUser5(String id) {
		return repo.findById(id).get();
	}
	public List<User5Entity> selectUser5s() {
		return repo.findAll();
	}
	public void updateUser5(User5Entity user5) {
		repo.save(user5);
	}
	public void deleteUser5(String id) {
		repo.deleteById(id);
	}
	
}
