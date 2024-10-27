# [백준 - G3] 1937. 욕심쟁이 판다

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 다이나믹 프로그래밍
- 그래프 이론
- 그래프 탐색
- 깊이 우선 탐색

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**

각각의 칸을 방문할때마다 그 칸을 포함해서 몇칸을 더 방문할 수 있는지를 기록해두면 다른 칸에서 그 기록한칸에 들어갈때 기록해둔 값을 사용하면 된다.

```java
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			ans = Math.max(ans, dfs(i, j));
		}
	}

	static int dfs(int y, int x) {
		if (memo[y][x] == -1) {
			int max = 0;
			for (int i = 0; i < 4; i++) {
				int nextY = y + dy[i];
				int nextX = x + dx[i];
				if (checkRange(nextY, nextX) && bamboos[nextY][nextX] > bamboos[y][x]) {
					max = Math.max(max, dfs(nextY, nextX));
				}
			}
			memo[y][x] = max + 1;
		}
		return memo[y][x];
	}

```

## :black_nib: **Review**

dfs에 메모이제이션을 결합한 문제

## 📡**Link**

https://www.acmicpc.net/problem/1937
