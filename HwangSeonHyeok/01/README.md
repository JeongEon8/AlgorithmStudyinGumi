# [백준 - g1] 16194. 카드 구매하기 2

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 다이나믹 프로그래밍

## :round_pushpin: **Logic**

dp로 (현제 기록된 장수,dp[사고난뒤 카드장수-들어있는장수]+카드팩가격)중 작은값을 기록하는식으로 풀면된다.

```java
  int[] dp = new int[n + 1];
		for(int i = 1;i<=n;i++) {
			dp[i] = cardArr[i];
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i] = Math.min(dp[i], dp[i - j] + cardArr[j]);
			}
		}

```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/16194
