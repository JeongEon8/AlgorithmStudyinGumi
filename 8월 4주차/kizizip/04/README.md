# [백준 - S3] 25418. 정수 a를 k로 만들기


## ⏰ **time**
20분

## :pushpin: **Algorithm**
DP, BFS

## ⏲️**Time Complexity**
O(k-a)

## :round_pushpin: **Logic**
1. BFS 큐에 시작값 a와 현재 연산 횟수 0 넣기
2. 방문 체크 배열(visited)로 이미 탐색한 값 건너뛰기
3. 큐에서 값 하나씩 꺼내서
- num == k이면 현재 연산 횟수 출력 후 종료
- 그렇지 않으면..
- num + 1 연산 후 방문하지 않았으면 큐에 넣기
- num * 2 연산 후 방문하지 않았으면 큐에 넣기
4. 큐가 빌 때까지 반복 → 최소 연산 횟수 탐색

## :black_nib: **Review**
각 단계에서 *2, +1 다 호출해서 Math.min()으로 비교하는 방식을 썼었는데 시간초과가 났당 

## 📡**Link**
https://www.acmicpc.net/problem/25418
