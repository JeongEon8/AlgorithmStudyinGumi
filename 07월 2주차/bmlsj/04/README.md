# [백준 - S5] 9655. 돌 게임

## ⏰  **time**
60분

## :pushpin: **Algorithm**
DP

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
- `game(n)`	을 `n`개의 돌이 남았을 때, 현재 차례인 사람이 이기면 1 지면 0이라고 정의


```java
public static int game(int curr) {

	if (curr == 0)
		return 0;

	if (dp[curr] != -1) {
		return dp[curr];
	}

	// 돌을 1 or 3개를 뺀 후, 상대가 질 경우
	if (curr - 1 >= 0 && game(curr - 1) == 0) {
		dp[curr] = 1;
		return 1;
	}

	if (curr - 3 >= 0 && game(curr - 3) == 0) {
		dp[curr] = 1;
		return 1;
	}

	// 그렇지 않을 경우, 현재 SK가 패배
	dp[curr] = 0;
	return 0;
}
```


## :black_nib: **Review**
- DP 모르게따.. DP 어렵네

## 📡 Link
https://www.acmicpc.net/problem/9655