
# [백준- S5] 16395. 파스칼의 삼각형

## ⏰  **time**
10분

## :pushpin: **Algorithm**
DP

## ⏲️**Time Complexity**


## :round_pushpin: **Logic**

1. dp[i][1]과 dp[i][i]를 1로 두어 파스칼의 삼각형 가장자리를 초기화
2. 내부 칸은 dp[i][j] = dp[i-1][j-1] + dp[i-1][j] 규칙으로 채운다
3. 누적된 테이블에서 원하는 위치 (n, k) 값을 출력

## :black_nib: **Review**

## 📡**Link**
- https://www.acmicpc.net/problem/16395
