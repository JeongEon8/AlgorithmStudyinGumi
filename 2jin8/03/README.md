# [백준- S1] 11057. 오르막 수
 
## ⏰  **time**
40분

## :pushpin: **Algorithm**
DP

## ⏲️**Time Complexity**
$O(N²)$

## :round_pushpin: **Logic**
- 표를 채우면 규칙을 찾을 수 있음

|  | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 (=total) |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| 1 | 1 | 1 | 1 | 1 | 1 | 1 | 1 | 1 | 1 | 1 | 10 |
| 2 | 10 | 9 | 8 | 7 | 6 | 5 | 4 | 3 | 2 | 1 | 55 |
| 3 | 55 | 45 | 36 | 28 | 21 | 15 | 10 | 6 | 3 | 1 | 220 |
- `dp[i][j] = dp[i][j-1] - dp[i-1][j-1]`
    - 단, `dp[i][0] = dp[i-1][10]`
```java
int[][] dp = new int[N + 1][M + 1];
Arrays.fill(dp[1], 1); // N이 1일 때는 모두 1
dp[1][M] = 10;

for (int i = 2; i <= N; i++) {
  dp[i][0] = dp[i - 1][M];
  int total = dp[i][0];
  for (int j = 1; j < M; j++) {
    dp[i][j] = dp[i][j - 1] - dp[i - 1][j - 1];
    if (dp[i][j] < 0)
      dp[i][j] += DIV;

    total = (total + dp[i][j]) % DIV;
  }
  dp[i][M] = total;
}
```

## :black_nib: **Review**
분명히 점화식이 세워질 것 같은데 계속 값이 이상하게 나오길래 또 이상하게 생각했나 싶었는데 뺄셈 잘못하고 있었다. 잠올때는 문제 풀지 않아야지ㅎ...

## 📡**Link**
- https://www.acmicpc.net/problem/11057
