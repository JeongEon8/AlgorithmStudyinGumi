# [SWEA - D3] 5215. 햄버거 다이어트

## ⏰  **time**
40분

## :pushpin: **Algorithm**
dp

## ⏲️**Time Complexity**
$O(N*L)$

## :round_pushpin: **Logic**
1. 칼로리와 맛점수 담을 배열 생성
```java
int[][] eval = new int[N+1][2]; // [0]은 맛점수 [1]은 칼로리
```
2. N개의 재료와 L까지의 칼로리를 담을 dp 배열 생성
```java
int[][] dp = new int[N+1][L+1];
```
3. dp[i][j]에 현재 확인하는 재료를 담을 수 없으면 dp[i-1][j]과 동일하므로 우선 값 넣기
4. 해당 칼로리에서 가장 큰 맛 점수 값 넣을 수 있도록 max 값 구하기
```java
            for(int i = 1; i <= N; i++) {
                for(int j = 0; j <= L; j++) {
                    dp[i][j] = dp[i-1][j];
                    
                    if(j >= eval[i][1]) dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - eval[i][1]] + eval[i][0]);
                }
            }
```


## :black_nib: **Review**
- dp 너무너무 오랜만 ..! 어려워!

## 📡 Link
https://swexpertacademy.com/main/code/problem/problemDetail.do
