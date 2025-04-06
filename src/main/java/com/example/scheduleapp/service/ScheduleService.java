package com.example.scheduleapp.service;

import com.example.scheduleapp.entity.Schedule;
import com.example.scheduleapp.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

//@RequiredArgsConstructor 를 사용하면
// 생성자를 자동으로 만들어 주기에 생성자를 만들 필요 없어짐.
@Service
public class ScheduleService {
    //private final 로 선언하는게 좋음.
    private final ScheduleRepository scheduleRepository;

    //생성자 주입
    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    // 일정 생성
    public Schedule createSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    //전체 일정 불러오기
    public List<Schedule> getSchedules() {
        return scheduleRepository.findAll();
    }

    //특정 일정 불러오기
    public Schedule getScheduleById(Long id) {
        // orElseThrow -> 값이 없으면 예외 던져.
        // findById(id) 했는데 값이 있으면 → 그 값을 바로 반환.
        //값이 없으면 → RuntimeException을 직접 만들어서 예외를 던짐.
        return scheduleRepository.findById(id).orElseThrow(() -> new RuntimeException("Schedule not found"));
    }

    //특정 일정 업데이트
    public Schedule updateSchedule(Long id, Schedule updatedSchedule) {
        //DB에서 수정할 일정(Schedule)을 찾아온다
        Schedule schedule = getScheduleById(id);
        //받아온 updatedSchedule 객체에서 제목이랑 내용을 꺼내서
        //기존 객체(schedule)에 덮어씌운다.
        schedule.setTitle(updatedSchedule.getTitle());
        schedule.setContent(updatedSchedule.getContent());
        //변경된 schedule 객체를 다시 DB에 저장(save)
        return scheduleRepository.save(schedule);
    }

    //특정 일정 삭제
    public void deleteSchedule(Long id) {
        scheduleRepository.deleteById(id);
    }
}
