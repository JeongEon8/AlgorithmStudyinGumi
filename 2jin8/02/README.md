# [백준 - G4] 17404. RGB거리 2
 
## ⏰  **time**
1시간

## :pushpin: **Algorithm**
DP

## ⏲️**Time Complexity**
$O(3 * N)$

## :round_pushpin: **Logic**
- 1번 집에 칠하는 색을 고정한 뒤, 칠하는 비용의 최솟값을 기록하면 됨
  - 색은 총 3가지(R, G, B)이므로 3번 반복하면 됨
- 1번 집에 빨강을 칠한다면 1번 집에 초록, 파랑을 칠하는 비용은 INF로 설정하기
  - 또한, N번 집에 빨강을 칠하는 비용을 INF로 설정하기 (1번 집 색 ≠ N번 집 색)
```java
int minCost = INF;
for (int i = 0; i < 3; i++) { // 1번 집에 칠할 색 정하기 (R, G, B)
  dp = copyArr();
  dp[0][i] = cost[0][i];
  dp[0][(i + 1) % 3] = INF; // 나머지 집은 선택 불가
  dp[0][(i + 2) % 3] = INF;
  dp[N - 1][i] = INF; // N번째 집은 같은 색으로 칠하기 불가

  // 2번 ~ N번째 집 칠하기
  for (int j = 1; j < N; j++) {
    // R
    dp[j][0] += Math.min(dp[j - 1][1], dp[j - 1][2]);

    // G
    dp[j][1] += Math.min(dp[j - 1][0], dp[j - 1][2]);

    // B
    dp[j][2] += Math.min(dp[j - 1][0], dp[j - 1][1]);
  }

  for (int j = 0; j < 3; j++) {
    minCost = Math.min(minCost, dp[N - 1][j]);
  }
}
```

## :black_nib: **Review**
아이디어 생각을 했으면 제발 끝까지 예시 돌려보자.. 아닌 것 같아서 괜히 삽질만 하지말고..

## 📡**Link**
- https://www.acmicpc.net/problem/17404
