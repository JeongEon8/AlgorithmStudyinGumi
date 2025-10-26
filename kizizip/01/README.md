# [백준 - S3] 14494. 다이나믹이 뭐예요?


## ⏰ **time**
10분

## :pushpin: **Algorithm**
DP

## ⏲️**Time Complexity**
O(n*m)

## :round_pushpin: **Logic**
1. dp 2차원 배열 생성 (경로의 수 저장)
2. 첫 행과 첫 열은 이동 경로가 1개뿐이므로 1로 초기화 
3. 각 칸 (i, j)에 대해 ... 위(dp[i-1][j]), 왼쪽(dp[i][j-1]), 대각선(dp[i-1][j-1])의 합을 구하고, num으로 나눔 
4. dp[n][m] 출력


## :black_nib: **Review** 


## 📡**Link**
https://www.acmicpc.net/problem/14494
