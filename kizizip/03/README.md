# [백준 - S2] 2823. 유턴 싫어 


## ⏰ **time**
20분

## :pushpin: **Algorithm**
그래프 이론

## ⏲️**Time Complexity**
O(r*c)

## :round_pushpin: **Logic**
1. 2차원 배열 map에서 각 칸을 탐색
2. 해당 칸이 '.'이면 상하좌우 4방 탐색
3. 인접한 '.' 칸 개수(cnt) 세기
4. 인접 '.' 개수가 1 이하이면 바로 1 출력 후 종료
5. 모든 칸 탐색 후 조건 만족하는 칸 없으면 0 출력

## :black_nib: **Review** 


## 📡**Link**
https://www.acmicpc.net/problem/2823
