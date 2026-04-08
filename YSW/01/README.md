# [백준 - G4] 1261. 알고스팟 (Easy)

## ⏰ **time**

50분

## :pushpin: **Algorithm**

- 그래프 이론
- 그래프 탐색
- 최단 경로
- 데이크스트라
- 격자 그래프
- 0-1 너비 우선 탐색

## ⏲️**Time Complexity**

$O(N * M * Log(N * M))$

## :round_pushpin: **Logic**

이 문제는 목적지까지 도달하는 경로 중 벽을 부수는 횟수(가중치)의 합이 최소가 되는 경로를 찾는 문제였다.
일반적인 BFS는 모든 간선의 가중치가 같을 때 최단 거리를 구하지만, 이 문제는 '벽을 부수지 않는 경우(가중치 0)'와 '벽을 부수는 경우(가중치 1)'로 가중치가 달라서 우선순위 큐를 활용해 벽을 적게 부순 경로를 우선적으로 탐색하도록 구현했다.
이렇게 하면 탐색 과정에서 목적지에 처음 도달하는 순간이 곧 벽을 최소한으로 부순 경우임이 보장된다.

```java
		while (!queue.isEmpty()) {
			Point curr = queue.poll();
			int currRow = curr.row;
			int currCol = curr.col;
			int currCount = curr.count;

			if (currRow == N - 1 && currCol == M - 1) {
				System.out.println(currCount);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nextRow = currRow + direction[i][0];
				int nextCol = currCol + direction[i][1];
				if (nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < M && !visited[nextRow][nextCol]
						&& maze[nextRow][nextCol] == 0) {
					queue.add(new Point(nextRow, nextCol, currCount));
					visited[nextRow][nextCol] = true;
				}

				if (nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < M && !visited[nextRow][nextCol]
						&& maze[nextRow][nextCol] == 1) {
					queue.add(new Point(nextRow, nextCol, currCount + 1));
					visited[nextRow][nextCol] = true;
				}
			}
		}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/1261
