# [백준 - 실버 1] 11057.오르막 수

## ⏰ **time**
1시간

## :pushpin: **Algorithm**
DP

## ⏲️ **Time Complexity**
$O(10^N)$

## :round_pushpin: **Logic**
1. dp[i][j] = dp[i-1][j] + dp[i][j-1]
```cpp
	for (int i = 2; i <= N; i++) {
		for (int j = 0; j < 10; j++) {
			if (j == 0) {
				dp[i][0] = 1;
				continue;
			}
			dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			dp[i][j] %= mod;
		}
	}
```

## :black_nib: **Review**
- 으악 점화식은 잘 세웠는데 틀렸다! 왜? mod를 안해서 ㅎ 열받돌

## 📡 Link
[https://www.acmicpc.net/problem/11057](https://www.acmicpc.net/problem/11057)
