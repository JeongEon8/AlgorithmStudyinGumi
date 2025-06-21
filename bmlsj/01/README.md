# [백준 - S1] 2178. 미로 탐색
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
BFS

## ⏲️**Time Complexity**
$O(N × M)$

## :round_pushpin: **Logic**
- (0, 0)부터 출발하여, 상하좌우 네 방향으로 갈 수 있는 칸을 탐색
- `map[nx][ny] == 1` 이고 `visited[nx][ny] == 0`인 경우만 이동
- `visited[x][y]` 값에 +1을 하여 `visited[nx][ny]`에 저장
- BFS는 한 칸씩 넓게 탐색하므로, 가장 먼저 도달한 경로가 최단 경로
- 탐색이 끝나면, 도착점 (n-1, m-1)의 `visited` 값을 출력


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
- BFS 오랜만에 풀어서 조건 벗어날 경우, return 으로 마무리했는데 덕분에 4방향을 모두 탐색하지 않았다. 


## 📡**Link**
- https://www.acmicpc.net/problem/2178
