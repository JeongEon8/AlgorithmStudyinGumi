# [백준 - 실버 4] 14495.피보나치 비스무리한 수열

## ⏰ **time**
5분(이지만, 백준 서버 터져서 30분 대기함.. 흑)

## :pushpin: **Algorithm**
DP

## ⏲️ **Time Complexity**
$O(N))$

## :round_pushpin: **Logic**
1. 점화식) `f(n) = f(n-1) + f(n-3)`
```cpp
	for (int i = 4; i <= n; i++) {
		dp[i] = dp[i - 1] + dp[i - 3];
	}
```

## :black_nib: **Review**
- 중요한 건, 언제나 `int` 범위로 해결이 되나 안되나를 꼭 확인할 것.

## 📡 Link
[https://www.acmicpc.net/problem/14495](https://www.acmicpc.net/problem/14495)
