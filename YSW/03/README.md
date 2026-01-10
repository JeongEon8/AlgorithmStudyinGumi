# [백준 - G5] 23352. 방탈출 (Easy)

## ⏰ **time**

50분

## :pushpin: **Algorithm**

- 그래프 이론
- 브루트포스 알고리즘
- 그래프 탐색
- 너비 우선 탐색

## ⏲️**Time Complexity**

$O(N^2*M^2)$

## :round_pushpin: **Logic**

임의의 방에서 다른 방으로 이동했을때 최단경로이고 그 경로가 가장 긴 방의 시작과 끝 방의 숫자의 합을 구하는 문제였다.
bfs를 돌리면 시작점에서 목적지들의 최단 경로로 가기 때문에 bfs가 끝날때 각 시작점에서의 가장 긴 경로를 얻을수 있기 때문에
bfs를 해서 경로가 가장 긴 경우를 경로길이와 시작과 끝 방의 합을 저장한다.
이 과정을 각 배열의 모든 방에서 반복해서 답을 구했다.

```java
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					bfs(i, j);
				}
			}
		}
		
	private static void bfs(int startRow, int startCol) {
		boolean[][] visited = new boolean[N][M];
		Queue<info> queue = new ArrayDeque<>();
		queue.add(new info(startRow, startCol, 0));
		visited[startRow][startCol] = true;
		int[][] direction = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
		int start = map[startRow][startCol];

		while (!queue.isEmpty()) {
			info cur = queue.poll();
			int curRow = cur.row;
			int curCol = cur.col;
			int move = cur.move;
			int end = map[cur.row][cur.col];

			if (move >= route) {
				if (move > route) {
					result = start + end;
				} else {
					result = Math.max(result, start + end);
				}
				route = move;
			}

			for (int i = 0; i < direction.length; i++) {
				int nextRow = curRow + direction[i][0];
				int nextCol = curCol + direction[i][1];

				if (nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < M && map[nextRow][nextCol] != 0
						&& !visited[nextRow][nextCol]) {
					queue.add(new info(nextRow, nextCol, move + 1));
					visited[nextRow][nextCol] = true;
				}
			}
		}
	}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/23352
