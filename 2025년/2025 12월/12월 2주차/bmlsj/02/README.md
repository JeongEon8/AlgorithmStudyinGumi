# [프로그래머스 - lv2] 멀리 뛰기

## ⏰  **time**

30분

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

1칸과 2칸만 이동할 수 있음
`n`번째 칸에 도달하려면 2가지 경우만 있음

1. `n-1` 칸에서 1칸 점프
2. `n-2` 칸에서 2칸 점프
=> 점화식: `dp[n] = dp[n-1] + dp[n-2]`

```java
public long solution(int n) {
        
    if (n <= 2) return n;
        
    long[] dp = new long[n + 1];
    dp[1] = 1L;
    dp[2] = 2L;

    for (int i = 3; i <= n; i++) {
        dp[i] = (dp[i - 1] + dp[i - 2])  % 1234567;
    }

    return dp[n];
}
```

## :black_nib: Review

## 📡**Link**

- <https://school.programmers.co.kr/learn/courses/30/lessons/12914>
