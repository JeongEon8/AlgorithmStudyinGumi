# [백준 - G4] 5427. 불
 
## ⏰  **time**
20분

## :pushpin: **Algorithm**
BFS

## ⏲️**Time Complexity**
O(RxC) = $O(N^2)$

## :round_pushpin: **Logic**

- 기존의 불! 문제에서 테스트 케이스만 추가한 문제

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
아 되게 양심 없는 문제였다 ㅎㅎ 하나더 풀게염

## 📡**Link**
- https://www.acmicpc.net/problem/5427
