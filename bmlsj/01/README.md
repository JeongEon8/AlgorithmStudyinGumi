# [백준 - S1] 2178. 미로 탐색
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
BFS

## ⏲️**Time Complexity**
$O(N log N)$

## :round_pushpin: **Logic**
- 최단 거리와 같게 풀이


```java
public static void find(int x, int y) {

	Queue<int[]> q = new LinkedList<>();
	q.offer(new int[] { x, y });

	while (!q.isEmpty()) {

		int[] v = q.poll();
		x = v[0];
		y = v[1];

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
				continue;
			}

			if (map[nx][ny] == 1 && visited[nx][ny] == 0) {
				visited[nx][ny] = visited[x][y] + 1;
				q.add(new int[] { nx, ny });
			}
		}
	}
}
```

## :black_nib: **Review**



## 📡**Link**
- https://www.acmicpc.net/problem/2178
