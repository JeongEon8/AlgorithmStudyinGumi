# [백준 - S3] 1340. 연도 진행바

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 구현, 문자열, 파싱

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

- 이번 해가 몇 퍼센트 지났는지 구하는 문제
- 해당 년도의 전체 일수를 분으로 바꾼다
- 입력한 날짜를 년도, 월, 일, 시, 분으로 나눠서 분으로 바꾼다.
  - 윤년을 확인하고 윤년이면 2월 일수에 +1을 해서 계산한다.
- 해당 년도의 총 일수를 구하고 입력한 년도까지의 일수에서 -1을 한다.
- 둘 다 분으로 바꾸고 나눠서 출력

## :black_nib: **Review**


## 📡**Link**

https://www.acmicpc.net/problem/1340