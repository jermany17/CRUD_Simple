package com.example.CRUD_Simple.service; // 속해있는 패키지

import com.example.CRUD_Simple.db.UserRepository; // UserRepository 인터페이스를 사용
import com.example.CRUD_Simple.model.UserEntity; // UserEntity 클래스를 사용
import org.springframework.beans.factory.annotation.Autowired; // @Autowired 어노테이션을 사용
import org.springframework.stereotype.Service; // @Service 어노테이션을 사용

import java.util.List; // List 인터페이스를 사용
import java.util.Optional; // Optional 클래스를 사용

@Service // 서비스 레이어의 역할을 한다
public class UserService {

    @Autowired // UserRepository의 객체를 자동으로 찾아서 userRepository 필드에 주입
    private UserRepository userRepository;

    // create // update
    public UserEntity save(UserEntity user){ return userRepository.save(user); }

    // read
    // List<UserEntity> = 여러 UserEntity 객체의 리스트. 여러 사용자 엔티티를 한 번에 반환하거나 처리할 때 사용
    public List<UserEntity> findAll(){
        return userRepository.findAll();
    }

    // delete
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    // find by id
    // Optional<UserEntity> = 단일 UserEntity 객체를 안전하게 감싸는 컨테이너. null 처리를 명시적으로 할 수 있게 도와줌.
    public Optional<UserEntity> findById(Long id){
        return userRepository.findById(id);
    }

    // filterScore
    // 주어진 점수 이상
    public List<UserEntity> filterScore(int score){
        return userRepository.findAllByScoreGreaterThanEqual(score);
    }
    // 주어진 점수 범위 내
    public List<UserEntity> filterScore(int min, int max){ return userRepository.findAllByScoreGreaterThanEqualAndScoreLessThanEqual(min, max); }
}