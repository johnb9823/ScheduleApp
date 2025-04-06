package com.example.scheduleapp.controller;

import com.example.scheduleapp.entity.Schedule;
import com.example.scheduleapp.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController는 응답할 데이터가 있는 경우에 사용한다.
//@Controller+ @ResponseBody 이다.
//@Component로 등록하여 Spring Bean으로 만든다.
@RestController
//요청 URL과 HTTP 메서드(GET, POST 등)를 컨트롤러의 메서드에 매핑하기 위해 사용
@RequestMapping("/schedules")
public class ScheduleController {
    //필드
    private final ScheduleService scheduleService;
    //생성자 주입
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    //생성
    //@PostMapping == @RequestMapping(method = RequestMethod.POST)
    //아래 처럼 url 경로를 생략한 경우에는 클래스 레벨에 @RequestMapping이 있을 때 유용함.
    @PostMapping
    // @RequestBody란?
    //클라이언트(사용자)가 요청을 보낼 때, 요청 본문(body)에 JSON 형식의 데이터를 담아 보낼 수 있음.
    //@RequestBody는 해당 JSON 데이터를 자바 객체(Schedule)로 변환하는 역할을 함.
    //즉, 클라이언트가 보낸 데이터를 Schedule 객체에 매핑함.
    public Schedule createSchedule(@RequestBody Schedule schedule) {
        return scheduleService.createSchedule(schedule);
    }

    //다건 조회
    //@GetMapping은 @RequestMapping(method = RequestMethod.GET)의 축약형
    @GetMapping
    public List<Schedule> getSchedules() {
        return scheduleService.getSchedules();
    }

    //단건 조회
    //@GetMapping은 @RequestMapping(method = RequestMethod.GET)의 축약형
    // 어떤 데이터를 불러올지 구분하기 위해 url 작성
    @GetMapping("/{id}")
    public Schedule getScheduleById(Long id) {
        return scheduleService.getScheduleById(id);
    }

    //수정
    //전체 자원 수정 (모든 필드 업데이트)
    //PATCH	일부 자원 수정 (변경된 필드만 업데이트)
    //@PathVariable은
    //URL에 들어있는 숫자나 문자를 자바 변수로 꺼내오는 도구
    @PutMapping("/{id}")
    public Schedule updateSchedule(@PathVariable Long id, @RequestBody Schedule schedule) {
        return scheduleService.updateSchedule(id, schedule);
    }

    //삭제
    // 특정 자원 삭제
    // @PathVariable은
    //URL에 들어있는 숫자나 문자를 자바 변수로 꺼내오는 도구
    @DeleteMapping("/{id}")
    public void deleteSchedule(@PathVariable Long id) {
        scheduleService.deleteSchedule(id);
    }
    // 쉽게 기억하는 법
    //URL에 {} ← 이거 보이면 → @PathVariable로 받는 거.
    ///users/{id} → @PathVariable Long id
}
