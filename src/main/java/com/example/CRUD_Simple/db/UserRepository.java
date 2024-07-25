package com.example.CRUD_Simple.db; // 속해있는 패키지

import com.example.CRUD_Simple.model.UserEntity; // UserEntity 클래스를 사용
import org.springframework.data.jpa.repository.JpaRepository; // JpaRepository 인터페이스를 사용

import java.util.List; // List 인터페이스를 사용

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    // JpaRepository interface를 상속받음을 의미
    // 기본적인 CRUD 메서드가 자동으로 제공

    // 쿼리 메소드 =  메서드 이름을 기준으로 JPA가 자동으로 쿼리 생성

    // 쿼리 메소드 예시 1
    // select * from user where score > ?
    // findAll = 모든 엔티티 반환
    // ByScore = score 기준
    // GreaterThanEqual = 크거나 같은 조건
    List<UserEntity> findAllByScoreGreaterThanEqual(int sc);

    // 쿼리 메소드 예시 2
    // select * from user where score >= ? and score <= ?
    // findAll = 모든 엔티티 반환
    // ByScore = score 기준
    // GreaterThanEqual = 크거나 같은 조건
    // And = 두 조건 만족
    // ScoreLessThanEqual = 작거나 같은 조건
    List<UserEntity> findAllByScoreGreaterThanEqualAndScoreLessThanEqual(int min, int max);
}