# [백준 - S1] 2667. 단지번호붙이기 (Easy)

## ⏰ **time**

50분

## :pushpin: **Algorithm**

- 그래프 이론
- 그래프 탐색
- 너비 우선 탐색
- 깊이 우선 탐색
- 격자 그래프
- 플러드 필

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**

전체 지도를 순회하며 아직 방문하지 않은 집을 찾을 때마다 BFS 탐색을 시작하여, 상하좌우로 연결된 모든 집의 개수를 세고 이를 리스트에 담아 정렬 후 출력하는 로직입니다.

```java
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j] && map[i][j] == 1) {
					queue.add(new int[] { i, j });
					visited[i][j] = true;
					int houseCount = 0;

					while (!queue.isEmpty()) {
						int[] current = queue.poll();
						int currentRow = current[0];
						int currentCol = current[1];
						houseCount++;

						for (int k = 0; k < 4; k++) {
							int nextRow = currentRow + direction[k][0];
							int nextCol = currentCol + direction[k][1];

							if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < n && !visited[nextRow][nextCol]
									&& map[nextRow][nextCol] == 1) {
								queue.add(new int[] { nextRow, nextCol });
								visited[nextRow][nextCol] = true;
							}
						}
					}
					houseCounts.add(houseCount);
				}
			}
		}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/2667