# [백준 - G3️] 1937. 욕심쟁이 판다
 
## ⏰  **time**
1시간

## :pushpin: **Algorithm**
DFS + DP

## :round_pushpin: **Logic**
- 모든 위치에서 DFS를 실행하면 시간초과가 발생하므로 현재 위치에서 이동할 수 있는 칸 수를 기록해야 함
- 현재 위치를 방문하지 않았다면 네 방향 탐색을 통해 이동할 수 있는 칸 수 세기
```java
static int dfs(int x, int y) {
  // 방문하지 않은 경우 (방문했다면 자신의 dp 값을 return)
  if (dp[x][y] != 0)
    return dp[x][y];

  dp[x][y] = 1; // 자기 자신도 이동할 수 있는 칸에 포함
  for (int i = 0; i < 4; i++) {
    int nx = x + dx[i];
    int ny = y + dy[i];
    if (nx < 0 || ny < 0 || nx >= N || ny >= N)
      continue;

    if (map[x][y] < map[nx][ny]) {
      // 현재 칸에서 이동할 수 있는 횟수가 더 큰 것으로 갱신
      dp[x][y] = Math.max(dp[x][y], dfs(nx, ny) + 1);
    }
  }
  return dp[x][y];
}
```

## :black_nib: **Review**
어떤 식으로 DP를 적용해야할지 몰라서 많이 고민을 했다. DFS랑 같이 사용하는 DP는 더 헷갈리는 듯.. 많이 문제를 풀어봐야 되겠다.

## 📡**Link**
- https://www.acmicpc.net/problem/1937
