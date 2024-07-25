package com.example.CRUD_Simple.controller; // 속해있는 패키지

import com.example.CRUD_Simple.model.UserEntity; // UserEntity 클래스를 사용
import com.example.CRUD_Simple.service.UserService; // UserService 클래스를 사용
import lombok.RequiredArgsConstructor; // 생성자 자동 생성(final), 의존성 주입
import org.springframework.web.bind.annotation.*; // Mapping, PathVariable, RequestParam 등

import java.util.List; // List 인터페이스를 사용

@RestController // rest api 처리하는 컨트롤러로 설정
@RequestMapping("/api/user")  // 기본 주소 지정
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;

    // create // update
    @PutMapping("")
    public UserEntity create(@RequestBody UserEntity userEntity){ return userService.save(userEntity); }

    // read
    @GetMapping("/all")
    public List<UserEntity> findAll(){
        return userService.findAll();
    }

    // delete
    @DeleteMapping("/id/{id}")
    public void delete(@PathVariable Long id){
        userService.deleteById(id);
    }

    // find by id
    @GetMapping("/id/{id}")
    public UserEntity findOne(@PathVariable Long id){
        var response = userService.findById(id);
        return response.orElse(null); // 값이 존재하면 해당 값을 반환, 존재하지 않으면 null 반환
    }

    // filterScore
    // 주어진 점수 이상
    @GetMapping("/score")
    public List<UserEntity> filterScore(@RequestParam int score){
        return userService.filterScore(score);
    }
    // 주어진 점수 범위 내
    @GetMapping("/min_max")
    public List<UserEntity> filterScore(@RequestParam int min, @RequestParam int max){ return userService.filterScore(min, max); }
}
