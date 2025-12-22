# [백준 - S1] 30106. 현이의 로봇 청소기 (Easy)

## ⏰ **time**

50분

## :pushpin: **Algorithm**

- 그래프 이론
- 그래프 탐색
- 너비 우선 탐색
- 플러드 필

## ⏲️**Time Complexity**

$O(N * M)$

## :round_pushpin: **Logic**

구역을 나누는 문제 였다.
전체 격자를 순회하면서 아직 방문하지 않은 칸을 발견하면 해당 칸을 시작점으로 BFS를 수행한다.
BFS 과정에서 상하좌우 인접한 칸 중 현재 칸과의 값 차이가 K 이하이면서 아직 방문하지 않은 칸만 큐에 넣어 탐색한다.
하나의 BFS가 끝나면 하나의 연결 요소 탐색이 완료된 것이므로 개수를 1 증가시킨다.

```java
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j]) {
					queue.add(new int[] { i, j });
					visited[i][j] = true;
					count++;
				}

				while (!queue.isEmpty()) {
					int[] current = queue.poll();
					int currentRow = current[0];
					int currentCol = current[1];

					for (int k = 0; k < 4; k++) {
						int moveRow = currentRow + move[k][0];
						int moveCol = currentCol + move[k][1];
						if (!(moveRow >= 0 && moveRow < N && moveCol >= 0 && moveCol < M)) {
							continue;
						}
						int diff = room[currentRow][currentCol] - room[moveRow][moveCol];

						if (!visited[moveRow][moveCol] && Math.abs(diff) <= K) {
							queue.add(new int[] { moveRow, moveCol });
							visited[moveRow][moveCol] = true;
						}
					}
				}
			}
		}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/30106
