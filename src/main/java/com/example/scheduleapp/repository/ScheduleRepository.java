package com.example.scheduleapp.repository;

import com.example.scheduleapp.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

}
//Repository를 interface로만 만들면,
//스프링이 런타임에 자동으로 구현체(진짜 클래스)를 만들어줌.
//즉, 직접 코드를 구현하지 않아도 스프링이 내부에서 알아서 해줌.
//JpaRepository 같은 기본 인터페이스를 상속해서 기능 재사용 가능
//이미 만들어져 있는 findAll(), findById(), save(), delete()
//이런 기본 기능들을 다 가져와서 쓸 수 있음