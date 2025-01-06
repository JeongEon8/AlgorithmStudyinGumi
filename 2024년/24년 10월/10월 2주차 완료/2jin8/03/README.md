# [백준 - S1] 1446. 지름길
 
## ⏰  **time**
40분

## :pushpin: **Algorithm**
DP

## ⏲️**Time Complexity**
$O(D)$

## :round_pushpin: **Logic**
- 우선 이전 위치에서 이동하는데 걸린 시간으로 dp 배열 채우기
- 현재 길로 오는 지름길이 존재하면 지름길을 통해 오는 방법과 이전 위치에서 이동하는 방법 비교하기
```java
int[] dp = new int[D + 1];
Arrays.fill(dp, INF);
dp[0] = 0;
for (int i = 1; i <= D; i++) {
  // 한 칸씩 이동하기
  dp[i] = dp[i - 1] + 1;

  // 지름길이 있다면 확인하기
  for (Edge prev : graph[i]) {
    dp[i] = Math.min(dp[i], dp[prev.x] + prev.d);
  }
}
```

## :black_nib: **Review**
최단경로 문제인줄 알고 다익스트라로 풀려고 했지만 어려웠고 반례가 존재했다.. DP를 사용할 수 있는 문제 같길래 그냥 DP를 사용해서 풀었다.

## 📡**Link**
- https://www.acmicpc.net/problem/1446
