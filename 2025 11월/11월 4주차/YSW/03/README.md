# [백준 - S2] 14231. 박스 포장 (Easy)

## ⏰ **time**

50분

## :pushpin: **Algorithm**

- 다이나믹 프로그래밍

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**

각 상자를 마지막 원소로 하는 증가 부분 수열의 길이를 DP로 계산한다.
i번째 상자보다 작은 모든 j번째 상자를 앞에 둘 수 있으므로 dp[i] = max(dp[j] + 1) 을 구한다.
모든 i에 대해 dp[i] 중 최댓값을 구한다.

```java
		for (int i = 1; i <= n; i++) {
			dp[i] = 1;
			for (int j = 1; j < i; j++) {
				if (boxsSize[j] < boxsSize[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			result = Math.max(result, dp[i]);
		}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/14231
