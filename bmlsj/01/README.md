# [백준- G3] 16236. 아기상어

## ⏰  **time**
120분

## :pushpin: **Algorithm**
BFS

## ⏲️**Time Complexity**
$O((N^4)logN)$

- BFS : $O(N^2)$
- PQ 삽입 : $(N^2)O(log(N^2))$
- 메인 while 문 : $O(N^2)$
- 전체 : $O(N^2) × O((N^2)logN)$

## :round_pushpin: **Logic**

1. 우선 순위가 필요
- `Node`의 우선 순위
	1. 거리가 가까운 순: `dis` 내림차순
	2. 위쪽을 먼저 가기:`x` 내림차순
	3. 왼쪽에 먼저 가기: `y` 내림차순

2. 상어가 움직일 때마다 `yum()` 실행
3. `yum()` 함수 로직
	- `bfs` 는 그냥 이동 / `queue`는 먹을 수 있는 물고기 위치
   1. 먹을 수 있을 물고기만 먹고 `dis + 1`
   2. 만약 빈 칸이거나 크기가 같다면 이동 가능 => `bfs`에 넣어 그냥 이동
4. `queue`에서 가장 우선순위가 위에 있는 노드 1개로만 이동한다.
5. 이동한 위치의 값을 0으로 변경하고, `cnt`에 이동한 거리인 `dis` 더한다.
6. 만약 크기만큼 먹었다면 물고기의 크기를 `+1` 한다.
   


```java
static PriorityQueue<Node> yum(int sx, int sy, int size) {

	PriorityQueue<Node> queue = new PriorityQueue<>(new Node());
	visited = new boolean[N][N];
	visited[sx][sy] = true;

	Queue<int[]> bfs = new ArrayDeque<int[]>();
	bfs.offer(new int[] { sx, sy, 0 }); // x, y, 거리

	while (!bfs.isEmpty()) {
		int[] curr = bfs.poll();
		int x = curr[0], y = curr[1], dis = curr[2];

		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx < 0 || ny < 0 || nx >= N || ny >= N)
				continue;
			if (visited[nx][ny])
				continue;
			if (map[nx][ny] > size)
				continue;

			visited[nx][ny] = true;

			if (map[nx][ny] > 0 && map[nx][ny] < size) {
				// 먹을 수 있는 물고기만
				queue.offer(new Node(nx, ny, map[nx][ny], dis + 1));
			}

			// 빈칸이나 같은 크기면 이동 가능
			bfs.offer(new int[] { nx, ny, dis + 1 });
		}
	}

	return queue;
}
```


## :black_nib: **Review**

어렵돵


## 📡**Link**
- https://www.acmicpc.net/problem/16236
