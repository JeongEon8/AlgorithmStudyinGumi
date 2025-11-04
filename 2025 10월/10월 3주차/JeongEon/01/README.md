# [백준 - 실버 2] 11048. 이동하기

## ⏰  **time**
20분

## :pushpin: **Algorithm**
다이나믹 프로그래밍 (DP)

## ⏲️ **Time Complexity**
- $O(N \times M)$  
  → DP 테이블을 한 번만 순회하며 각 위치에서 최대값을 계산함.

## :round_pushpin: **Logic**
1. `arr[i][j]`: 각 위치에 놓인 사탕 개수  
2. `dp[i][j]`: `(1, 1)`에서 `(i, j)`까지 올 수 있는 경로 중 **사탕 최대합**
3. 점화식:  
```cpp
   dp[i][j] = arr[i][j] + max(
       dp[i-1][j-1],  // 대각선 위
       dp[i-1][j],    // 위
       dp[i][j-1]     // 왼쪽
   );
```

4. (1,1)부터 시작하여 오른쪽 또는 아래쪽 또는 대각선 아래로만 이동 가능
```cpp
for (int i = 1; i <= n; i++) {
  for (int j = 1; j <= m; j++) {
    dp[i][j] = arr[i][j] + max(dp[i - 1][j - 1], max(dp[i - 1][j], dp[i][j - 1]));
  }
}
```

## :black_nib: **Review**

* 경로 자체가 아니라 **사탕의 최대 개수**를 구하는 문제.
* 단순 DP 문제이지만, `대각선도 포함된다는 점`이 포인트!
* `dp[i][j]`를 `arr[i][j]`로 초기화해두면 깔끔하게 처리 가능.

## 📡 Link
[https://www.acmicpc.net/problem/11048](https://www.acmicpc.net/problem/11048)
