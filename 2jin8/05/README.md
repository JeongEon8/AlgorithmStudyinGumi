# [백준 - G4] 4485. 녹색 옷 입은 애가 젤다지?
 
## ⏰  **time**
20분

## :pushpin: **Algorithm**
BFS + 우선순위 큐

## :round_pushpin: **Logic**
- 잃는 루피를 기준으로 오름차순 정렬하는 우선순위 큐 만들기
- 잃는 루피가 가장 적은 것부터 탐색을 시작해서 최종 위치(`(N-1, N-1)`)에 도착하면 잃는 루피 수를 반환하기
```java
static int bfs() {
	PriorityQueue<Point> pq = new PriorityQueue<>();
	pq.offer(new Point(0, 0, map[0][0]));
	visited[0][0] = true;

	int[][] move = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	while (!pq.isEmpty()) {
		// 잃는 루피가 가장 적은 것부터 poll
		Point point = pq.poll();
		// 제일 아래 칸에 도착하면 탐색 종료
		if (point.x == N - 1 && point.y == N - 1) {
			return point.rupee;
		}

		for (int i = 0; i < 4; i++) {
			int nx = point.x + move[i][0];
			int ny = point.y + move[i][1];
			// 범위를 벗어나거나 이미 방문한 지역이면 탐색 X
			if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny])
				continue;

			pq.offer(new Point(nx, ny, point.rupee + map[nx][ny]));
			visited[nx][ny] = true;
		}
	}
	return -1;
}
```

## :black_nib: **Review**
상하좌우로 이동하면서 `최단 거리`를 구하는 문제가 아니라 `최소/최대 XX 구하기`와 같은 식이면 BFS 탐색에 우선순위 큐를 곁들이는 문제인 것 같다. 
비슷한 문제를 SWEA에서 풀어서 쉽게 풀 수 있었다. 역시 문제를 많이 접해보는 게 최고인 듯..

## 📡**Link**
- [백준 4485_녹색 옷 입은 애가 젤다지?](https://www.acmicpc.net/problem/4485)
