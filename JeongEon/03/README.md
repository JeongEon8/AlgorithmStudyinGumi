# [백준 - 실버 2] 11055.가장 큰 증가하는 부분 수열

## ⏰ **time**
6분

## :pushpin: **Algorithm**
DP

## ⏲️ **Time Complexity**
$O(NlogN))$

## :round_pushpin: **Logic**
1. dp[i] = max(dp[i], dp[j] + arr[i])
```cpp
	for (int i = 0; i < N; i++) {
		dp[i] = arr[i];
		for (int j = 0; j < i; j++) {
			if (arr[j] < arr[i]) {
				dp[i] = max(dp[i], dp[j] + arr[i]);
			}
		}
	}
```

## :black_nib: **Review**
- 안풀리는 거 풀다가 이거 넘어오니까 술술 풀리네 ㅎㅎ

## 📡 Link
[https://www.acmicpc.net/problem/11055](https://www.acmicpc.net/problem/11055)
