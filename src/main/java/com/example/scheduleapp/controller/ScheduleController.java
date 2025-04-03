package com.example.scheduleapp.controller;

import com.example.scheduleapp.entity.Schedule;
import com.example.scheduleapp.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {
    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }
//1. @RequestBody란?
//클라이언트(사용자)가 요청을 보낼 때, 요청 본문(body)에 JSON 형식의 데이터를 담아 보낼 수 있음.
//@RequestBody는 해당 JSON 데이터를 자바 객체(Schedule)로 변환하는 역할을 함.
//즉, 클라이언트가 보낸 데이터를 Schedule 객체에 매핑함.

    //생성
    @PostMapping
    public Schedule createSchedule(@RequestBody Schedule schedule) {
        return scheduleService.createSchedule(schedule);
    }

    //다건 조회
    @GetMapping
    public List<Schedule> getSchedules() {
        return scheduleService.getSchedules();
    }

    //단건 조회
    @GetMapping("/{id}")
    public Schedule getScheduleById(Long id) {
        return scheduleService.getScheduleById(id);
    }

    //수정
    @PutMapping("/{id}")
    public Schedule updateSchedule(@PathVariable Long id, @RequestBody Schedule schedule) {
        return scheduleService.updateSchedule(id, schedule);
    }

    //삭제
    @DeleteMapping("/{id}")
    public void deleteSchedule(@PathVariable Long id) {
        scheduleService.deleteSchedule(id);
    }
}
