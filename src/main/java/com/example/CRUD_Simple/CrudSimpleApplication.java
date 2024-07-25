package com.example.CRUD_Simple; // 속해있는 패키지

import org.springframework.boot.SpringApplication; // Spring Boot 애플리케이션을 실행하는 데 필요한 클래스
import org.springframework.boot.autoconfigure.SpringBootApplication; // Spring Boot 애플리케이션의 설정을 자동으로 구성하는 어노테이션

@SpringBootApplication
public class CrudSimpleApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSimpleApplication.class, args); // Spring Boot 애플리케이션을 실행하는 메서드
	}

}
