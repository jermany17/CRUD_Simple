package com.example.CRUD_Simple.model; // 속해있는 패키지

import jakarta.persistence.Entity; // JPA 엔티티임
import jakarta.persistence.GeneratedValue; // ID 값 자동 생성 지정
import jakarta.persistence.GenerationType; // ID 값의 생성 전략 지정
import jakarta.persistence.Id; // 엔티티의 기본 키
import lombok.AllArgsConstructor; // 모든 필드를 가지는 생성자 추가
import lombok.Builder;            // 빌더 패턴을 적용
import lombok.Data;               // 메서드 생성(getter, setter 등)
import lombok.NoArgsConstructor;  // 기본 생성자 추가

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "user")
public class UserEntity{
    @Id // 엔티티의 기본 키
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID 값이 데이터베이스에 의해 자동 생성
    private Long id;

    private String name;

    private int score;
}
