# [백준 - S2] 4097. 수익

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 구현
- 애드 혹

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

i-1까지의 dp값이 음수면 현제 시점부터 구간을 다시 시작하고 양수면 이전 구간에 포함해 dp[i-1]을 더해주면된다. 이렇게 기록한 값들의 최댓값을 찾으면 답이다.

```java
	while (true) {
		int n = Integer.parseInt(in.readLine());
		if (n == 0)
			break;
		long[] dp = new long[n + 1];
		for (int i = 1; i <= n; i++) {
			dp[i] = Long.parseLong(in.readLine());
		}
		Long ans = -100000L;
		for (int i = 1; i <= n; i++) {
			dp[i] = Math.max(dp[i - 1], 0) + dp[i];
			if (ans < dp[i]) {
				ans = dp[i];
			}
		}
		System.out.println(ans);
	}

```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/4097
