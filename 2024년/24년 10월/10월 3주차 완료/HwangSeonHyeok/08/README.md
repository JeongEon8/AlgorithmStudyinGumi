# [백준 - S4] 15624. 피보나치 수 7

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 수학
- 다이나믹 프로그래밍

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

dp로 기록하면서 피보나치수를 구한다.

```java
if (n > 0) {
	dp[1] = 1;
	for (int i = 2; i <= n; i++) {
		dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
	}
}

```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/15624
