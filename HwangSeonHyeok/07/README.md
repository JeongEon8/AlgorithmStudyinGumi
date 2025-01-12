# [백준 - G5] 12887. 경로 게임

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 그래프 이론
- 그래프 탐색
- 너비 우선 탐색

## ⏲️**Time Complexity**

$O(m)$

## :round_pushpin: **Logic**
바꿀수 있는 하얀색 칸의 최대 개수는 지나가지 않아도 되는 하얀색 칸의 개수이다.  
bfs로 왼쪽에서 오른쪽으로 갈 수 있는 최단 경로를 구하고 (전체 흰색 칸의 갯수) - (최단경로거리)로 답을 구할 수 있다.
```java
	static int bfs(int x, int y) {
		Queue<Point> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[2][m];
		q.add(new Point(y, x, 1));
		visited[y][x] = true;
		while (!q.isEmpty()) {
			Point current = q.poll();
			if (current.x == m - 1) {
				return current.step;
			}
			for (int i = 0; i < 3; i++) {
				int nextY = current.y + dy[i];
				int nextX = current.x + dx[i];
				if (nextY >= 0 && nextY < 2 && !visited[nextY][nextX] && graph[nextY][nextX]) {
					visited[nextY][nextX] = true;
					q.add(new Point(nextY, nextX, current.step + 1));
				}
			}
		}
		return -1;

	}
```

## :black_nib: **Review**


## 📡**Link**

https://www.acmicpc.net/problem/12887
