# [백준] 17086. 아기 상어 2   
 
## ⏰  **time**
40분 

## :pushpin: **Algorithm**
그래프 이론, 너비 우선 탐색 

## ⏲️**Time Complexity**
536 ms

## :round_pushpin: **Logic**
- 매 좌표마다 bfs 돌리므로, visit배열 새로 선언
- 큐 선언 후 시작 좌표 x, y, 거리 저장
- 새로운 좌표에 1이 있다면, 목표에 도달한 것이므로 길이를 반환한다.
- 새로운 좌표에 1이 없다면, 아직 목표 달성이 아님. 새로운 좌표, 거리 저장해준다.
```java
		visit = new boolean[n][m];
		visit[x][y] = true;

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { x, y, 0 });

		while (!queue.isEmpty()) {
			int[] now = queue.poll();

			for (int i = 0; i < 8; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				int length = now[2] + 1;

				if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visit[nx][ny]) {
					if (map[nx][ny] == 1) {
						return length;
					}

					queue.offer(new int[] { nx, ny, length });
					visit[nx][ny] = true;
				}

			}

		}
```

## :black_nib: **Review**
- bfs는 dfs보다도 경험이 적어 실력이 많이 부족하다.
- 그렇지만... 이제 큐가 뭔지는 안다...ㅎㅎ 큐가 빌 때까지 돌려주기~ 

## 📡**Link**
- https://www.acmicpc.net/problem/17086
