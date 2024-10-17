# [백준 - G5] 15486. 퇴사 2
 
## ⏰  **time**
1시간 30분

## :pushpin: **Algorithm**
DP

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
- dp[i]: i일까지 얻을 수 있는 최대 금액
- `dp[i] = Max(dp[i], dp[i - 1])`
- 현재 요일의 상담을 수행할 수 있는 경우
  - `dp[i + time[i]] = Max(dp[i + time[i]], dp[i] + pay[i])`
```java
for (int i = 1; i < M; i++) {
  dp[i] = Math.max(dp[i], dp[i - 1]); // 이전까지의 최대 금액 vs 현재까지의 최대 금액

  // 현재 회의를 선택할 수 있는 경우
  if (i + time[i] < M) {
    dp[i + time[i]] = Math.max(dp[i + time[i]], dp[i] + pay[i]);
  }
}
System.out.println(dp[N + 1]);
```

## :black_nib: **Review**
점화식 세우는데 시간이 오래 걸려서 다른 풀이를 참고했는데 아예 생각을 잘못하고 있었다.. 

## 📡**Link**
- https://www.acmicpc.net/problem/15486
