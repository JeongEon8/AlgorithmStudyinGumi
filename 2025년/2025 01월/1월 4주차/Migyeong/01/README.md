# [백준 - 실버 1] 2156. 포도주 시식
 
## ⏰  **time**
20분

## :pushpin: **Algorithm**
DP

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. i번째 포도주를 마시지 않는 경우 → dp[i] = dp[i-1]
2. i번째 포도주를 마시고, (i-1)번째 포도주를 건너뛰는 경우 → dp[i] = dp[i-2] + arr[i]
3. (i-1)번째 포도주와 i번째 포도주를 연속으로 마시는 경우 → dp[i] = dp[i-3] + arr[i-1] + arr[i]
```java
static int recur(int N) {	
	if(dp[N] == null) {
		dp[N] = Math.max(Math.max(recur(N - 2), recur(N - 3) + arr[N - 1]) + arr[N], recur(N - 1));
	}
	return dp[N];
}
```

## :black_nib: **Review**
- 으어어..

## 📡 Link
https://www.acmicpc.net/problem/2156
