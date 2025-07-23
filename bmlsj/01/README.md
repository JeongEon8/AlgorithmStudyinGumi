# [백준 - S5] 8979. 올림픽
 
## ⏰  **time**
1시간 30분

## :pushpin: **Algorithm**
BFS

## ⏲️**Time Complexity**
O(RxC) = $O(N^2)$

## :round_pushpin: **Logic**

- 불 확산하는 경우와 지훈이의 이동. 2가지 경우의 BFS가 필요

1. 불이 먼저 퍼지는 시간을 미리 계산해둠 → `fireTime[][]`

2. 이후 지훈이의 이동을 BFS로 시뮬레이션하며:
	- 방문하지 않은 칸
	- 벽이 아닌 칸
	- 불이 아직 도착하지 않았거나, 지훈이보다 나중에 도착하는 칸
	이 조건을 만족할 때만 이동 가능
3. 만약 지훈이가 범위 밖(지도 밖)으로 이동하면 탈출 성공 → `visited[][] + 1` 출력
4. 끝까지 탈출하지 못하면 `IMPOSSIBLE` 출력

```java
static void escape(int x, int y) {

	int[][] fireTime = new int[R][C];
	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			fireTime[i][j] = -1; // 불이 퍼지지 않은 상태로 초기화
		}
	}

	Queue<int[]> queue = new ArrayDeque<int[]>();
	Queue<int[]> fireQueue = new ArrayDeque<>();

	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			if (map[i][j].equals("F")) {
				fireQueue.offer(new int[] { i, j });
				fireTime[i][j] = 0;
			}
		}
	}

	while (!fireQueue.isEmpty()) {
		int[] curr = fireQueue.poll();
		int fx = curr[0];
		int fy = curr[1];

		for (int i = 0; i < 4; i++) {
			int nx = fx + dx[i];
			int ny = fy + dy[i];

			if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
				continue;
			}

			if (fireTime[nx][ny] == -1 && map[nx][ny].equals(".")) {
				fireTime[nx][ny] = fireTime[fx][fy] + 1;
				fireQueue.offer(new int[] { nx, ny });
			}
		}
	}

	queue.offer(new int[] { x, y });

	// 지훈이의 시작 위치가 이미 가장자리일 경우
	if (x == 0 || x == R - 1 || y == 0 || y == C - 1) {
		ans = 1;
		return;
	}

	while (!queue.isEmpty()) {
		int[] curr = queue.poll();
		x = curr[0];
		y = curr[1];

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
				ans = visited[x][y] + 1;
				return;
			}

			if (visited[nx][ny] == 0 && map[nx][ny].equals(".")
					&& (fireTime[nx][ny] == -1 || fireTime[nx][ny] > visited[x][y] + 1)) {

				visited[nx][ny] = visited[x][y] + 1;
				queue.offer(new int[] { nx, ny });
			}
		}

	}
}
```

## :black_nib: **Review**
`(fireTime > 지훈이 이동 시간)` 조건이 중요하며, 동시 도착 불가
=> 몬가 어려웠다

## 📡**Link**
- https://www.acmicpc.net/problem/4179
