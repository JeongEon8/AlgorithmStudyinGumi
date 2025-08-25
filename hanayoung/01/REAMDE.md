# [백준 - S2] 16493. 최대 페이지 수

## ⏰  **time**
15분

## :pushpin: **Algorithm**
배낭문제

## ⏲️**Time Complexity**
$O(N*M)$

## :round_pushpin: **Logic**
1. 2차원 배열 생성, 페이지 수와 일 수 의미
```java
int[][] dp = new int[M+1][N+1]; // 페이지수, 일 수
```
2. M개의 챕터이므로, 1부터 M까지 순환하며 넣는 경우와 넣지 않는 경우 탐색
```java
        for(int i = 1; i < M+1; i++) {
            for(int j = 1; j < N+1; j++) {
                if(j < books[i][1]) dp[i][j] = dp[i-1][j];
                else dp[i][j] = Math.max(dp[i-1][j-books[i][1]]+books[i][0], dp[i-1][j]);
            }
        }
```


## :black_nib: **Review**
- 배낭문제랑 친해지기..어렵당

## 📡**Link**
- https://www.acmicpc.net/problem/16493
