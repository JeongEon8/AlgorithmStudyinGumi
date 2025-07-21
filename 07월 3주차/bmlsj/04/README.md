# [백준 - G3] 2206. 벽 부수고 이동하기
 
## ⏰  **time**
60분

## :pushpin: **Algorithm**
BFS

## ⏲️**Time Complexity**
$O(N×M)$


## :round_pushpin: **Logic**

- BFS 상태에 `벽을 부쉈는지 여부`까지 포함해야 하므로 `visited[x][y][broken]` 형식의 3차원 배열을 사용한다.
- 같은 좌표 `(x, y)`라도 `벽을 부쉈는지 여부`에 따라 다른 경로로 간주된다.
- 한 번도 벽을 안 부쉈다면 벽을 한 번 부수고 이동 가능하며, 이미 부쉈다면 벽은 통과 불가능하다.


```java
static int breakWalls() {

	Queue<Node> queue = new ArrayDeque<Node>();

	queue.offer(new Node(0, 0, 0));
	visited[0][0][0] = true;

	int[][] dist = new int[N][M];
	dist[0][0] = 1;

	while (!queue.isEmpty()) {

		Node curr = queue.poll();

		if (curr.x == N - 1 && curr.y == M - 1) {
			return dist[curr.x][curr.y];
		}

		for (int i = 0; i < 4; i++) {
			int nx = curr.x + dx[i];
			int ny = curr.y + dy[i];

			if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
				continue;
			}

			// 벽x
			if (!visited[nx][ny][curr.broken] && map[nx][ny] == 0) {
				visited[nx][ny][curr.broken] = true;
				dist[nx][ny] = dist[curr.x][curr.y] + 1;
				queue.offer(new Node(nx, ny, curr.broken));
			}

			// 벽o이고 안부쉈을 때
			if (!visited[nx][ny][1] && curr.broken == 0 && map[nx][ny] == 1) {
				visited[nx][ny][1] = true;
				dist[nx][ny] = dist[curr.x][curr.y] + 1;
				queue.offer(new Node(nx, ny, 1));
			}
		}
	}
	return -1;
}
```

## :black_nib: **Review**
기존에는 벽인 위치를 모두 저장해 각 벽을 0으로 바꾸고 BFS를 매번 실행했는데, 시간초과가 발생했다.
벽의 개수만큼 BFS를 반복하고 있기 때문에 BFS는 $O(N×M)$이므로 최악의 경우 $O(벽 수 × N × M)$이 된다.


## 📡**Link**
- https://www.acmicpc.net/problem/2206
