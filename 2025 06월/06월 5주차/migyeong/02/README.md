# [백준 - 골드 5] 7576. 토마토
 
## ⏰  **time**
50분

## :pushpin: **Algorithm**
BFS

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 익지 않은 토마토의 총 개수를 구하고, 토마토가 익을 때마다 -1씩 구함
2. bfs 탐색을 완료하고 익지 않은 토마토의 개수가 0이 아닐 경우, -1 출력
3. 토마토가 모두 익었을 경우, 익은 일수의 최대 값을 구한 cnt 값 출력
```java
private static void bfs(Queue<int[]> queue) {
	while (!queue.isEmpty()) {
		int[] temp = queue.poll();
		int cx = temp[0];
		int cy = temp[1];
		int time = temp[2];

		cnt = Math.max(cnt, time);

		for (int i = 0; i < 4; i++) {
			int nx = cx + dx[i];
			int ny = cy + dy[i];

			if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] != 0) {
				continue;
			}
			map[nx][ny] = 1;
			tomato -= 1;
			queue.offer(new int[]{nx, ny, time + 1});

		}
	}

	check = tomato == 0;
}
```

## :black_nib: **Review**
- 토마토 N,M 헷갈려서 런타임 에러가 났어요...ㅠㅜ

## 📡 Link
https://www.acmicpc.net/problem/7576
