# [백준 - 실버 3] 11727. 2xn 타일링 2
 
## ⏰  **time**
1시간

## :pushpin: **Algorithm**
DP

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 점화식 : dp[n] = dp[n-1]+dp[n-2]*2  
```cpp
	dp[0] = 1;
	dp[1] = 3;
	for (int i = 2; i < n; i++) {
		dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007;
	}
```

## :black_nib: **Review**
- 

## 📡 Link
https://www.acmicpc.net/problem/11727
