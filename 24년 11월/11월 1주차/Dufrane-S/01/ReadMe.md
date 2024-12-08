# [BOJ - S1] 14940. 쉬운 최단 거리
 
## ⏰  **time**
40분

## :pushpin: **Algorithm**
BFS

## ⏲️**Time Complexity**
$O(N²)$

## :round_pushpin: **Logic**
1. bfs를 이용해 갈 수 있는 모든 좌표의 거리를 업데이트 해준다.
```
while (!q.isEmpty()) {
			Dot now = q.poll();
			for (int i = 0; i < 4; i++) {
				int ny = now.y + dy[i];
				int nx = now.x + dx[i];
				if (ny < 0 || nx < 0 || ny == n || nx == m || done[ny][nx] || box[ny][nx] == 0)
					continue;
				done[ny][nx] = true;
				Dot ndot = new Dot(ny, nx);
				q.add(ndot);
				box[ny][nx] = box[now.y][now.x] + 1;
			}
		}
```
## :black_nib: **Review**



## 📡**Link**

https://www.acmicpc.net/problem/14940
