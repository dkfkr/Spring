package kr.ch10.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ch10.dto.User6DTO;
import kr.ch10.mapper.User6Mapper;

@Service
public class User6MapperService {
	
	@Autowired
	private User6Mapper mapper;
	
	public int insertUser6(User6DTO dto) {
		return mapper.insertUser6(dto);
	};
	
	public User6DTO selectUser6(String id) {
		return mapper.selectUser6(id);
	};
	
	public List<User6DTO> selectUser6s() {
		return mapper.selectUser6s();
	};
	
	public int updateUser6(User6DTO dto) {
		return mapper.updateUser6(dto);
	};
	
	public int deleteUser6(String id) {
		return mapper.deleteUser6(id);
	};
	
	
}
