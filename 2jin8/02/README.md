# [백준- S1] 10844. 쉬운 계단 수
 
## ⏰  **time**
40분

## :pushpin: **Algorithm**
DP

## ⏲️**Time Complexity**
$O(NM)$

## :round_pushpin: **Logic**
- 규칙을 찾으면 아래와 같은 점화식이 나옴
  - `dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1]`
  - 단, `dp[i][0] = dp[i-1][1]`, `dp[i][9] = dp[i-1][8]`
```java
// N = 1
for (int i = 0; i < M; i++) {
    dp[1][i] = 1;
}

// 2 ~ N
for (int i = 2; i <= N; i++) {
    dp[i][0] = dp[i -1][1];
    for (int j = 1; j < M - 1; j++) {
        dp[i][j] = (dp[i - 1][j - 1] % DIV) + (dp[i - 1][j + 1] % DIV);
    }
    dp[i][9] = dp[i - 1][8];
}
```

## :black_nib: **Review**
규칙 찾기 쉽지않네

## 📡**Link**
- https://www.acmicpc.net/problem/10844
