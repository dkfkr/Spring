package kr.ch10.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ch10.dto.User4DTO;
import kr.ch10.mapper.User4Mapper;

@Service
public class User4MapperService {
	
	@Autowired
	private User4Mapper mapper;
	
	public int insertUser4(User4DTO dto) {
		return mapper.insertUser4(dto);
	};
	
	public User4DTO selectUser4(String id) {
		return mapper.selectUser4(id);
	};
	
	public List<User4DTO> selectUser4s() {
		return mapper.selectUser4s();
	};
	
	public int updateUser4(User4DTO dto) {
		return mapper.updateUser4(dto);
	};
	
	public int deleteUser4(String id) {
		return mapper.deleteUser4(id);
	};
	
	
}
