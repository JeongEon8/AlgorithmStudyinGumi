# [백준 - G4] 17069. 파이프 옮기기 2
 
## ⏰  **time**
1시간 30분

## :pushpin: **Algorithm**
DP

## :round_pushpin: **Logic**
- (i, j)에 벽이 없어야 이동할 수 있음
- (i, j)에 가로로 올 수 있는 경우 = (i, j - 1)에 가로로 올 수 있는 경우 + (i, j - 1)에 대각선으로 올 수 있는 경우
  - `dp[0][i][j] = dp[0][i][j-1] + dp[1][i][j-1]`
- (i, j)에 세로로 올 수 있는 경우 = `(i - 1, j)에 세로로 올 수 있는 경우 + (i - 1, j)에 대각선으로 올 수 있는 경우
  - `dp[2][i][j] = dp[2][i-1][j] + dp[1][i-1][j]`
- (i, j)에 대각선으로 올 수 있는 경우 = (i - 1, j - 1)에 가로로 올 수 있는 경우 + (i - 1, j - 1)에 세로로 올 수 있는 경우 + (i - 1, j - 1)에 대각선으로 올 수 있는 경우
    - 이때, (i - 1, j), (i, j - 1)에 벽이 없어야 함
    - `dp[1][i-1][j-1] = dp[0][i-1][j-1] + dp[2][i-1][j-1] + dp[1][i-1][j-1]`
```java
dp[0][1][2] = 1;
for (int i = 1; i <= N; i++) {
  for (int j = 3; j <= N; j++) {
    // 벽이면 아예 올 수 없음
    if (arr[i][j] == 1)
      continue;

    dp[0][i][j] = dp[0][i][j - 1] + dp[2][i][j - 1];
    dp[1][i][j] = dp[1][i - 1][j] + dp[2][i - 1][j];

    // 대각선 파이프가 놓여지는 위치에 벽이 없어야 함
    if (arr[i - 1][j] == 0 && arr[i][j - 1] == 0)
      dp[2][i][j] = dp[0][i - 1][j - 1] + dp[1][i - 1][j - 1] + dp[2][i - 1][j - 1];
  }
}
```

## :black_nib: **Review**
파이프 옮기기 1 문제는 완탐으로 풀 수 있었지만 이 문제는 N의 범위가 커서 DP로 풀어야 하는 문제였다. DFS + DP 문제인줄 알았는데 그냥 순수하게 DP를 사용하는 문제였다ㅎ..
점화식을 세우는 것이 어려워서 풀이를 참고해서 풀었다. DP 풀 때는 배열의 인덱스 의미를 잘 생각한 뒤 점화식을 세우는 습관을 가져야 될 것 같다고 느꼈다.

## 📡**Link**
- https://www.acmicpc.net/problem/17069