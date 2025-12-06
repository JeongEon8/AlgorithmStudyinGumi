# [백준 - S1] 31946. 죽음의 등굣길 (Easy)

## ⏰ **time**

50분

## :pushpin: **Algorithm**

- 그래프 이론
- 그래프 탐색
- 너비 우선 탐색
- 격자 그래프

## ⏲️**Time Complexity**

$O(N*M*X^2)$

## :round_pushpin: **Logic**

(1,1)에서 출발하여 시작 칸의 색(startBlock)과 같은 칸들만 갈 수 있다.
이동은 4방향이 아니라 맨해튼 거리 X 이하인 모든 칸(dr,dc) = (i, j)로 점프 형태 이동이며
|i| + |j| ≤ X 를 만족하는 모든 칸을 한 번에 검사한다.
이러한 BFS를 통해 (N, M)에 도달할 수 있으면 “ALIVE”, 아니면 “DEAD” 출력한다.

```java
		X = Integer.parseInt(br.readLine());
		queue.add(new int[] { 1, 1 });
		visited[1][1] = true;
		int startBlock = grid[1][1];

		while (!queue.isEmpty()) {
			int[] currentPos = queue.poll();
			int curRow = currentPos[0];
			int curCol = currentPos[1];
			if (curRow == N && curCol == M) {
				System.out.println("ALIVE");
				return;
			}

			for (int i = -X; i <= X; i++) {
				int remin = X - Math.abs(i);

				for (int j = -remin; j <= remin; j++) {
					int nextRow = curRow + i;
					int nextCol = curCol + j;

					if (nextRow >= 1 && nextRow <= N && nextCol >= 1 && nextCol <= M && !visited[nextRow][nextCol]
							&& grid[nextRow][nextCol] == startBlock) {
						queue.add(new int[] { nextRow, nextCol });
						visited[nextRow][nextCol] = true;
					}
				}
			}
		}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/31946
