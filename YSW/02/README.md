# [백준 - S1] 2178. 미로 탐색 (Easy)

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 그래프 이론
- 그래프 탐색
- 너비 우선 탐색
- 격자 그래프

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

Queue에 현재 위치랑 이동 횟수 저장하고 bfs로 탐색했다.

```java
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int currentRow = current[0];
			int currentCol = current[1];
			int count = current[2];

			if (currentRow == N - 1 && currentCol == M - 1) {
				result = count;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int moveRow = currentRow + move[i][0];
				int moveCol = currentCol + move[i][1];

				if (moveRow >= 0 && moveRow < N && moveCol >= 0 && moveCol < M && !visited[moveRow][moveCol]
						&& map[moveRow][moveCol] == 1) {
					queue.offer(new int[] { moveRow, moveCol, count + 1 });
					visited[moveRow][moveCol] = true;
				}
			}
		}
```

## :black_nib: **Review**

일반적인 BFS라 금방 풀었다.

## 📡**Link**

https://www.acmicpc.net/problem/2178
