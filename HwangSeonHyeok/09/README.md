# [백준 - G5] 6593. 상범 빌딩

## ⏰ **time**

50분

## :pushpin: **Algorithm**

- 정렬

## ⏲️**Time Complexity**

$O(N^3)$

## :round_pushpin: **Logic**
z축을 포함한 bfs를 돌려서 S부터 E까지의 최단거리를 구한다.
```java
static int bfs() {

Queue<Pos> q = new ArrayDeque<Pos>();
q.add(startPoint);
visited[startPoint.l][startPoint.r][startPoint.c] = true;
while (!q.isEmpty()) {
	Pos current = q.poll();
	for (int i = 0; i < 6; ++i) {
		int nextl = current.l + dl[i];
		int nextr = current.r + dr[i];
		int nextc = current.c + dc[i];
		if (building[nextl][nextr][nextc] && !visited[nextl][nextr][nextc]) {
			if (nextl == endPoint.l && nextr == endPoint.r && nextc == endPoint.c)
				return current.step + 1;
			visited[nextl][nextr][nextc] = true;
			q.add(new Pos(nextl, nextr, nextc, current.step + 1));
		}
	}
}

return -1;
}
```

## :black_nib: **Review**
오타를 못찾아 디버깅이 오래걸렸다..

## 📡**Link**

https://www.acmicpc.net/problem/6593
