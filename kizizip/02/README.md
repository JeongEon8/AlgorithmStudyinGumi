# [백준 - S4] 14402. 야근


## ⏰ **time**
20분

## :pushpin: **Algorithm**
해시를 사용한 집합과 맵

## ⏲️**Time Complexity**
O(q)

## :round_pushpin: **Logic**
1. 이름별 출근 `+`, 퇴근 `-`을 해시맵으로 관리
2. 출근시 해당 이름의 출근 횟수 +1
3. 퇴근시, 출근 기록이 없음 or 이미 0이면 부정 퇴근.. count +1
4. 정상 퇴근이면 출근 횟수를 1 감소
5. 야근 횟수 모두 더해서 결과 출력


## :black_nib: **Review** 
뭔가 헷갈렸다

## 📡**Link**
https://www.acmicpc.net/problem/14402
