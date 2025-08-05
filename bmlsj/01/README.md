
# [백준- G4] 3055. 탈출
## ⏰  **time**
60분

## :pushpin: **Algorithm**
BFS

## ⏲️**Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**

- 물이 먼저 퍼지고, 고슴도치가 이동해야한다.
- 1회씩만 진행해야하기 때문에, for문을 사용해 각 큐의 크기만큼만 진행할 수 있게 구현

```java
static void move(int x, int y) {

	Queue<int[]> queue = new ArrayDeque<int[]>();
	Queue<int[]> water = new ArrayDeque<int[]>();
	queue.offer(new int[] { x, y });
	visited[x][y] = 1;

	// 물 위치
	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) {
			if (map[i][j].equals("*")) {
				water.offer(new int[] { i, j });
			}
		}
	}

	while (!queue.isEmpty()) {
		// 물 먼저 이동
		int waterSize = water.size();
		for (int i = 0; i < waterSize; i++) {
			int[] curr = water.poll();
			int wx = curr[0];
			int wy = curr[1];

			for (int d = 0; d < 4; d++) {
				int nx = wx + dx[d];
				int ny = wy + dy[d];
				if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
					continue;
				}

				if (map[nx][ny].equals(".")) {
					map[nx][ny] = "*";
					water.offer(new int[] { nx, ny });
				}
			}
		}

		// 고슴도치 이동
		int size = queue.size();
		for (int i = 0; i < size; i++) {
			int[] curr = queue.poll();
			x = curr[0];
			y = curr[1];

			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];

				if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
					continue;
				}

				if (map[nx][ny].equals("D")) {
					visited[nx][ny] = visited[x][y] + 1;
					return;
				}

				if (visited[nx][ny] == 0 && map[nx][ny].equals(".")) {
					visited[nx][ny] = visited[x][y] + 1;
					queue.offer(new int[] { nx, ny });
				}
			}
		}
	}
}
```

## :black_nib: **Review**
탈출하고 싶은 나으 마음을 표출...


## 📡**Link**
- https://www.acmicpc.net/problem/3055

