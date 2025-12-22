# [백준 - S1] 16194. 카드 구매하기 2 (Easy)

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 다이나믹 프로그래밍

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**

dp[i]를 i개짜리 카드팩 가격으로 초기화한다.
i를 j와 i-j로 나누는 모든 경우를 확인한다.
나눠서 사는 경우와 한 번에 사는 경우 중 최소 비용을 선택한다.
이를 1부터 N까지 반복해서 dp[N]을 구한다.

```java
		for (int i = 1; i <= N; i++) {
			dp[i] = Integer.parseInt(inputs[i - 1]);
			for (int j = 1; j < i; j++) {
				dp[i] = Math.min(dp[i], dp[i - j] + dp[j]);
			}
		}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/16194
