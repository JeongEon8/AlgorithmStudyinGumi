# [BOJ - G2] 16946. 벽 부수고 이동하기 4
 
## ⏰  **time**
70분

## :pushpin: **Algorithm**
BFS

## ⏲️**Time Complexity**
$O(N²)$

## :round_pushpin: **Logic**
1. bfs를 이용해 빈 공간의 크기를 파악
2. 벽을 부술 경우 상하좌우의 공간과 연결되므로 상하좌우 공간의 크기 합 + 1
3. 같은 공간이 좌, 상과 연결되어 있을 수 있기 때문에 크기로 구분 불가 -> 태그를 이용해 구분
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

https://www.acmicpc.net/problem/16946
