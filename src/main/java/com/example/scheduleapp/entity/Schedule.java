package com.example.scheduleapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
//Entity 클래스는
// Repository에서 DB 읽고 쓸 때
//Service에서 비즈니스 로직 짤 때
//Controller에서 API 요청/응답 받을 때
// 사용됨.
//Entity는 데이터베이스 테이블을 자바 객체로 표현한 클래스.
//이걸 기반으로 CRUD, 비즈니스 로직, API 요청 처리 등을 다룬다.

//DB 테이블과 매핑되는 엔티티라는 뜻이야.
//→ Schedule이라는 이름의 테이블이 만들어짐.
@Entity
//이건 JPA Auditing 기능을 사용하겠다는 뜻이야.
//→ @CreatedDate, @LastModifiedDate 같은 자동 날짜 기록 기능을 쓰기 위해 필요함.
@EntityListeners(AuditingEntityListener.class)

//Lombok 어노테이션들
@Getter //@Getter → 모든 필드의 getter 자동 생성
@Setter //@Setter → 모든 필드의 setter 자동 생성
@NoArgsConstructor //@NoArgsConstructor → 파라미터 없는 생성자 생성
@AllArgsConstructor //@AllArgsConstructor → 모든 필드를 받는 생성자 생성
public class Schedule {

    @Id //PK 기본키
    // id 값이 자동 증가되게 설정.
    //MySQL의 AUTO_INCREMENT랑 비슷함.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 기본키로 사용할 id 필드, Long 타입

    //일정(Schedule)은 한 명의 사용자(User) 와 연결된다는 뜻.
    // → 일정 여러 개가 한 유저에 연결되는 N:1 관계
    @ManyToOne
    // 이 필드가 외래키로 매핑되며, 컬럼명은 "user_id"
    //→ nullable = false → null이 될 수 없음 (반드시 유저와 연결되어야 함)
    @JoinColumn(name = "user_id", nullable = false)
    private User user; //실제로 연결되는 User 객체 (엔티티 연관관계)

    private String title; //일정의 제목을 저장할 필드
    private String content; //일정의 내용을 저장할 필드

    @CreatedDate // 엔티티가 처음 저장될 때 자동으로 현재 날짜/시간이 들어감
    private LocalDateTime createdAt; // 일정이 생성된 시각을 저장하는 필드

    @LastModifiedDate //엔티티가 수정될 때마다 자동으로 현재 날짜/시간으로 업데이트됨
    private LocalDateTime updatedAt; //수정된 시각을 저장하는 필드
}
