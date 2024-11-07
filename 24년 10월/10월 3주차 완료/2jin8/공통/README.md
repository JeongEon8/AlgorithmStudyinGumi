# [백준 - D5] 2096. 내려가기
 
## ⏰  **time**
15분

## :pushpin: **Algorithm**
DP

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
- 첫 번째 칸은 자신의 윗 칸 & 오른쪽 윗 칸에 영향을 받음
  - `dp[i][0] = Math.xxx(dp[i-1][0], dp[i-1][1])`
- 두 번째 칸은 자신의 윗 칸 & 왼쪽 윗 칸 & 오른쪽 윗 칸에 영향을 받음
  - `dp[i][1] = Math.xxx(dp[i-1][0], Math.xxx(dp[i-1][1], dp[i-1][2])`
- 세 번째 칸은 자신의 윗 칸 & 왼쪽 윗 칸에 영향을 받음
  - `dp[i][2] = Math.xxx(dp[i-1][1], dp[i-1][2])`
```java
for (int i = 1; i <= N; i++) {
  minDP[i][0] = Math.min(minDP[i - 1][0], minDP[i - 1][1]) + arr[i][0];
  minDP[i][1] = Math.min(minDP[i - 1][0], Math.min(minDP[i - 1][1], minDP[i - 1][2])) + arr[i][1];
  minDP[i][2] = Math.min(minDP[i - 1][1], minDP[i - 1][2]) + arr[i][2];

  maxDP[i][0] = Math.max(maxDP[i - 1][0], maxDP[i - 1][1]) + arr[i][0];
  maxDP[i][1] = Math.max(maxDP[i - 1][0], Math.max(maxDP[i - 1][1], maxDP[i - 1][2])) + arr[i][1];
  maxDP[i][2] = Math.max(maxDP[i - 1][1], maxDP[i - 1][2]) + arr[i][2];
}
```

## :black_nib: **Review**
전에 풀었던 DP 문제와 비슷해서 쉽게 점화식을 세울 수 있었다.

## 📡**Link**
- https://www.acmicpc.net/problem/2096
