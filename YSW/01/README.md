# [백준 - S1] 22869. 징검다리 건너기 (small) (Easy)

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 다이나믹 프로그래밍

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**

이 문제는 1번 돌에서 시작해 n번 돌까지 도달 가능한지를 묻는 문제입니다.
각 돌을 정점이라고 생각하면, 이동 조건을 만족하는 경우 두 돌 사이에 간선이 존재하는 그래프로 볼 수 있습니다.
dp[i]를 i번 돌에 도달 가능한지 여부로 정의했습니다.
처음에는 dp[1] = true로 두고, 도달 가능한 돌 i에 대해서 이후 돌 j로 이동이 가능한지 검사했습니다.
이동 비용이 k 이하라면 dp[j]를 true로 갱신합니다.
이렇게 왼쪽에서 오른쪽으로 모든 가능한 이동을 검사하면 최종적으로 dp[n]이 true인지 여부로 답을 판단할 수 있습니다.

```java
		for (int i = 1; i < n; i++) {
			if (!dp[i]) {
				continue;
			}
			for (int j = i + 1; j <= n; j++) {
				if (dp[j])
					continue;

				int power = (j - i) * (1 + Math.abs(stones[i] - stones[j]));

				if (power <= k) {
					dp[j] = true;
				}
			}
		}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/22869
