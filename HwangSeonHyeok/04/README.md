# [백준 - S3] 31575. 도시와 비트코인

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 그래프 이론
- 그래프 탐색
- 너비 우선 탐색

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
오른쪽 아래로만 내려갈 수 있는 bfs문제
```java
static boolean bfs() {
	Queue<Point> q = new ArrayDeque<>();
	q.add(new Point(0, 0));
	boolean[][] visited = new boolean[m][n];
	visited[0][0] = true;
	while (!q.isEmpty()) {
		Point current = q.poll();
		if (current.y == m - 1 && current.x == n - 1)
			return true;
		if (inCity(current.y + 1, current.x) && !visited[current.y + 1][current.x]
				&& city[current.y + 1][current.x] == 1) {
			visited[current.y + 1][current.x] = true;
			q.add(new Point(current.y + 1, current.x));
		}
		if (inCity(current.y, current.x + 1) && !visited[current.y][current.x + 1]
				&& city[current.y][current.x + 1] == 1) {
			visited[current.y][current.x + 1] = true;
			q.add(new Point(current.y, current.x + 1));
		}
	}

	return false;
}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/31575
