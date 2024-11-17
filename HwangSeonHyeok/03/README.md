# [백준 - S1] 30106. 현이의 로봇 청소기

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 그래프 이론
- 그래프 탐색
- 너비 우선 탐색
- 플러드 필

## ⏲️**Time Complexity**

$O(NM)$

## :round_pushpin: **Logic**

모든 칸을 돌면서 청소하지 않은 칸을 찾으면 높이 차이가 K이하인 곳만 갈 수 있는 bfs를 돌리면서 청소한다. 이런식으로 bfs를 들어간 횟수를 구하면 된다.

```java
	static void bfs(int y, int x) {
		Queue<Area> q = new ArrayDeque<>();
		visited[y][x] = true;
		q.add(new Area(y, x));
		while (!q.isEmpty()) {
			Area current = q.poll();
			for (int i = 0; i < 4; i++) {
				int nextY = current.y + dy[i];
				int nextX = current.x + dx[i];
				if (checkRange(nextY, nextX) && !visited[nextY][nextX]
						&& Math.abs(room[current.y][current.x] - room[nextY][nextX]) <= k) {
					visited[nextY][nextX] = true;
					q.add(new Area(nextY, nextX));
				}
			}

		}
	}

```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/30106
