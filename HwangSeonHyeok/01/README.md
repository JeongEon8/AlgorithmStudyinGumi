# [백준 - G4] 1261. 알고스팟 

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 그래프 이론
- 그래프 탐색
- 최단 경로
- 데이크스트라
- 0-1 너비 우선 탐색
## ⏲️**Time Complexity**

$O(NM)$

## :round_pushpin: **Logic**
부숴야하는 벽의 최소 수를 구해야 하므로 부순 벽의 수를 cost로 가지는 다익스트라 알고리즘을 사용한다. 각 노드마다 상하좌우 4방으로 갈 수 있고 벽이 없으면 0코스트 있으면 1코스트가 증가한다.

```java
pq.add(new Node(0, 0, 0));
dist[0][0] = 0;
while (!pq.isEmpty()) {
	Node now = pq.poll();
	if (now.cost > dist[now.y][now.x])
		continue;
	for (int i = 0; i < 4; i++) {
		int nextY = now.y + dy[i];
		int nextX = now.x + dx[i];
		if (nextY < 0 || nextX < 0 || nextY >= n || nextX >= m)
			continue;
		if (dist[nextY][nextX] > now.cost + maze[nextY][nextX]) {
			dist[nextY][nextX] = now.cost + maze[nextY][nextX];
			pq.add(new Node(nextY, nextX, dist[nextY][nextX]));
		}
	}
}
```

## :black_nib: **Review**
알고리즘 계절학기에서 예시로 나왔던 문제

## 📡**Link**

https://www.acmicpc.net/problem/1261
