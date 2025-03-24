# [백준 - 실버 5] 9656. 돌 게임 2

## ⏰  **time**
10분

## :pushpin: **Algorithm**
구현, 수학

## ⏲️**Time Complexity**
$O(n)$

## :round_pushpin: **Logic**
1. 남은 돌이 개수가 0이 될 때까지 반복
2. 남은 돌의 개수가 3보다 클 경우 3씩 빼고, 3보다 작을 경우 1씩 빼
3. turn 수 1씩 증가시켜서 turn이 짝수일 경우 상근이가 이긴 거고, 홀수면 창영이가 이긴 것
```java
while(N > 0) {
 if(N < 3) {
  N -= 1;
 } else {
  N -= 3;
 }
 turn += 1;
}
```

## :black_nib: **Review**
- 돌 게임 2 돌 게임이랑 완전 비슷한 문제 최고다

## 📡 Link
https://www.acmicpc.net/problem/9656
