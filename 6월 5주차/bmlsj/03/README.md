# [백준 - S1] 1697. 숨바꼭질
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
BFS

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
- 수빈이의 현재 위치 `N`에서 동생의 위치 `K`까지 도달하는 최단 시간을 찾는 문제
- `x-1`, `x+1`, `2x` 의 위치로 이동할 수 있다.



```java
public static int bfs(int x, int cnt) {

	Queue<int[]> queue = new ArrayDeque<int[]>();
	queue.add(new int[] { x, cnt });

	while (!queue.isEmpty()) {
		int[] q = queue.poll();
		x = q[0];
		cnt = q[1];

		for (int i = 0; i < 3; i++) {
			int nx = 0;

			if (i == 2)
				nx = x * 2;
			else
				nx = x + dx[i];

			if (nx < 0 || nx > 200000)  // 맵의 범위 체크 
				continue;
			if (nx == K)
				return cnt;

			if (!visited[nx]) {
				visited[nx] = true;
				queue.add(new int[] { nx, cnt + 1 });
			}
		}
	}

	return -1;  // K에 도달할 수 없는 경우
}
```

## :black_nib: **Review**
 * 범위 체크를 잘해야 한다.
 * n과 k가 100,000까지 이므로 2배인 200,000까지 갈 수 있음
 * 기존에는 map의 범위를 `K+1`까지 둬서, 많은 경우의 수를 탐지하지 못했다


## 📡**Link**
- https://www.acmicpc.net/problem/1697
