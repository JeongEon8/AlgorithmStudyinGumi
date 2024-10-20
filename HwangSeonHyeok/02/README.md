# [백준 - G5] 2096. 내려가기

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 다이나믹 프로그래밍
- 슬라이딩 윈도우

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

메모리가 굉장히 작은 문제라 최대 최소를 계산하고 현제 계산 결과를 이전 줄로 올리는 식으로 계산하였다.

```java
	for (int i = 0; i < 3; i++) {
		dp[i][0] = Integer.parseInt(split[i]);
		dp[i][1] = Integer.parseInt(split[i]);
	}
	int[][] current = new int[3][2];
	for (int i = 1; i < n; i++) {
		split = in.readLine().split(" ");
		for (int j = 0; j < 3; j++) {
			current[j][0] = Integer.parseInt(split[j]);
			current[j][1] = Integer.parseInt(split[j]);
		}
		current[0][0] += Math.max(dp[0][0], dp[1][0]);
		current[0][1] += Math.min(dp[0][1], dp[1][1]);

		current[1][0] += Math.max(dp[0][0], Math.max(dp[1][0], dp[2][0]));
		current[1][1] += Math.min(dp[0][1], Math.min(dp[1][1], dp[2][1]));

		current[2][0] += Math.max(dp[1][0], dp[2][0]);
		current[2][1] += Math.min(dp[1][1], dp[2][1]);
		for (int j = 0; j < 3; j++) {
			dp[j][0] = current[j][0];
			dp[j][1] = current[j][1];
		}

	}

```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/2096
