# [백준- G5] 9084. 동전
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
DP

## ⏲️**Time Complexity**
$O(NM)$

## :round_pushpin: **Logic**
- 모든 동전에 대해서 만들 수 있는 경우를 하나씩 확인하기
- 만드려는 금액이 현재 동전보다 크거나 같으면 `dp[i] += dp[i - coin]`
```java
dp = new int[M + 1];
dp[0] = 1;
for (int coin : coins) {
    // 각 코인으로 만들 수 있는 경우를 더하기
    for (int i = 1; i <= M; i++) {
        if (i < coin) continue;

        dp[i] += dp[i - coin];
    }
}
```

## :black_nib: **Review**
DP 오랜만에 푸니까 너무 헷갈린다악

## 📡**Link**
- https://www.acmicpc.net/problem/9084
