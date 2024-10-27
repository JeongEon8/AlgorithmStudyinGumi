# [백준 - S2] 28450. 컨벤 데드가 하고싶어요

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 다이나믹 프로그래밍

## ⏲️**Time Complexity**

$O(NM)$

## :round_pushpin: **Logic**

왼쪽에서 오는경우와 위에서 오는경우중 지금까지 눈치력이 더 적은 경우에서 오는식으로 해서 눈치력이 은신력이하인지 판단하면된다.

```java
for (int i = 2; i <= n; i++) {
	dp[i][0] = (int) 1e9;
}
for (int i = 2; i <= m; i++) {
	dp[0][i] = (int) 1e9;
}
int stealth = Integer.parseInt(in.readLine());
for (int i = 1; i <= n; i++) {
	for (int j = 1; j <= m; j++) {
		dp[i][j] += Math.min(dp[i - 1][j], dp[i][j - 1]);
	}
}
if (stealth < dp[n][m]) {
	System.out.println("NO");
} else {
	System.out.println("YES");
	System.out.println(dp[n][m]);
}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/28450
