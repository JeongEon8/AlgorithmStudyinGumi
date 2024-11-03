# [백준- S2] 1699. 제곱수의 합
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
DP

## ⏲️**Time Complexity**
$O(N√N)$

## :round_pushpin: **Logic**
- 점화식: `dp[i] = Math.min(dp[i], dp[i - 제곱수] + 1)`
  - dp[4] = dp[2²] = 1, dp[9] = dp[3²] = 1, dp[16] = dp[4²] = 1, …
  - 제곱수는 항의 개수가 무조건 1 ⇒ 항의 개수가 적으려면 제곱수가 들어가야 함
- 41의 경우 `6² + 2² + 1²`보다 `5² + 4²`이 항의 개수가 더 적음
  - 따라서 자신 바로 전의 제곱수만 확인하는 것이 아니라 **1부터 자기 자신 바로 전의 제곱수까지 확인**해야 함
```java
Arrays.fill(dp, MAX);
dp[0] = 0; dp[1] = 1;
dp[2] = 2; dp[3] = 3;
for (int i = 4; i <= N; i++) {
  int sqrt = (int) Math.sqrt(i);
  for (int j = 1; j <= sqrt; j++) {
    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
  }
}
```

## :black_nib: **Review**
처음에 바로 전의 제곱수만 확인했더니 틀렸다. 문제를 풀었다고 바로 제출하는 것이 아니라 여러 반례들을 좀 생각해보자

## 📡**Link**
- https://www.acmicpc.net/problem/1699
