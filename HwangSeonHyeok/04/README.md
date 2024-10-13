# [백준 - S1] 24392. 영재의 징검다리

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 다이나믹 프로그래밍

## ⏲️**Time Complexity**

$O(NM)$

## :round_pushpin: **Logic**

dp로 이전줄의 어느칸에서 올수있는지를 더해주면 되는 문제이다.

```java
n -= 2;
for (; n >= 0; n--) {
	for (int i = 0; i < m; i++) {
		if (dp[n][i] == 1) {
			dp[n][i] = dp[n + 1][i];
			if (i > 0) {
				dp[n][i] += dp[n + 1][i - 1];
				dp[n][i] %= mod;
			}
			if (i < m - 1) {
				dp[n][i] += dp[n + 1][i + 1];
				dp[n][i] %= mod;
			}
		}
	}
}
int ans = 0;
for (int i = 0; i < m; i++) {
	if (dp[0][i] != 0) {
		ans = (ans + dp[0][i]) % mod;
	}
}

```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/24392
