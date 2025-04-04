# ScheduleApp

## erd
![웹 이미지](https://github.com/johnb9823/ScheduleApp/blob/main/scheduleappERD.png)

## schedule api
|          | Method | URL             | 설명                    | Request                   | Response                       | 상태코드      |
|----------|--------|-----------------|-------------------------|----------------------------------------|--------------------------------|---------------|
| 일정등록 | POST   | /schedules      | 새 일정을 생성합니다.   | 요청 boby       | 등록 정보       | 200: 정상등록 |
| 일정조회 | GET    | /schedules      | 모든 일정을 조회합니다. |         -      | 다건 응답 정보    | 200: 정상조회 |
| 일정조회 | GET    | /schedules/{id} | 특정 일정을 조회합니다. | 요청 param        | 단건 응답 정보   | 200: 정상조회 |
| 일정수정 | PUT    | /schedules/{id} | 기존 일정을 수정합니다. | 요청 boby | 수정 후 정보 | 200: 정상수정 |
| 일정삭제 | DELETE | /schedules/{id} | 특정 일정을 삭제합니다. | 요청 param      |      -      | 200: 정상삭제 |

## user api
|          | Method | URL             | 설명                    | Request    | Response       | 상태코드      |
|----------|--------|-----------------|-------------------------|------------|----------------|---------------|
| 유저등록 | POST   | /schedules      | 새 유저를 생성합니다.   | 요청 body  | 등록정보       | 200: 정상등록 |
| 유저조회 | GET    | /schedules      | 모든 유저를 조회합니다. | -          | 다건 응답 정보 | 200: 정상조회 |
| 일정조회 | GET    | /schedules/{id} | 특정 유저를 조회합니다. | 요청 param | 단건 응답 정보 | 200: 정상조회 |
| 유저수정 | PUT    | /schedules/{id} | 유저 정보를 수정합니다. | 요청 body  | 수정 후 정보   | 200: 정상수정 |
| 유저삭제 | DELETE | /schedules/{id} | 특정 유저를 삭제합니다. | 요청 param | -              | 200: 정상삭제 |
