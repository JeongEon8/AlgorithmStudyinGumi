# [백준 - S2] 1699. 제곱수의 합

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 수학
- 다이나믹 프로그래밍

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**

제곱수들을 루트n까지 다 구해두고 dp로 어느 제곱수에서 최소 개수로 만들 수 있는지 계산했다.

```java
	int maxpow = (int) Math.floor(Math.sqrt(n));
	int[] dp = new int[n + 1];
	int[] pow = new int[maxpow + 1];
	for (int i = 1; i <= maxpow; i++) {
		pow[i] = i * i;
	}
	for (int i = 1; i <= n; i++) {
		dp[i] = Integer.MAX_VALUE;
		for (int j = 1; j <= Math.floor(Math.sqrt(i)); j++) {
			dp[i] = Math.min(dp[i - pow[j]] + 1, dp[i]);
		}
	}
```

## :black_nib: **Review**

반례도 많은데 처음에 계산도 안해보고 그리디로 접근했다가 틀렸다.

## 📡**Link**

https://www.acmicpc.net/problem/1699
