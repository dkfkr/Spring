package kr.ch10.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ch10.dto.User5DTO;
import kr.ch10.mapper.User5Mapper;

@Service
public class User5MapperService {
	
	@Autowired
	private User5Mapper mapper;
	
	public int insertUser5(User5DTO dto) {
		return mapper.insertUser5(dto);
	};
	
	public User5DTO selectUser5(String id) {
		return mapper.selectUser5(id);
	};
	
	public List<User5DTO> selectUser5s() {
		return mapper.selectUser5s();
	};
	
	public int updateUser5(User5DTO dto) {
		return mapper.updateUser5(dto);
	};
	
	public int deleteUser5(String id) {
		return mapper.deleteUser5(id);
	};
	
	
}
