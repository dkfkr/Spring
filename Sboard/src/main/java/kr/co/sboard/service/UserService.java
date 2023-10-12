package kr.co.sboard.service;


import kr.co.sboard.dto.UserDTO;
import kr.co.sboard.entity.TermsEntity;
import kr.co.sboard.entity.UserEntity;
import kr.co.sboard.repository.TermsRepository;
import kr.co.sboard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private TermsRepository termsRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    public TermsEntity findByTerms(){
        return termsRepository.findById(1).get();
    }

    public void insertUser(UserDTO dto){

        dto.setPass(encoder.encode(dto.getPass()));

        UserEntity entity = dto.toEntity();

        userRepository.save(entity);
    }

    public int countUid(String uid) {
        return userRepository.countByUid(uid);
    }

    public int countNick(String nick) {
        return userRepository.countByNick(nick);
    }

    public int countHp(String hp) {
        return userRepository.countByUid(hp);
    }



}