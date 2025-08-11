
# [백준- G4] 2636. 치즈

## ⏰  **time**
60분

## :pushpin: **Algorithm**
BFS

## ⏲️**Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**

1. (0, 0)부터 시작해 접근할 수 있는 `1`만 녹인다
2. 녹일 치즈들을 배열에 저장해 `0`으로 바꾼다.

```java
// 외부에서 접근 가능한 0만 외부 벽이라 간주
// 외부에서 만난 치즈는 배열에 저장 후, 한시간 후 녹인다
static void getCheese(ArrayList<Node> melt) {

	for (Node node : melt) {
		map[node.x][node.y] = 0;
	}

}

static ArrayList<Node> findWall() {

	Queue<Node> queue = new ArrayDeque<>();
	boolean[][] visited = new boolean[N][M];
	ArrayList<Node> toMelt = new ArrayList<>();
	queue.offer(new Node(0, 0));
	visited[0][0] = true;

	while (!queue.isEmpty()) {

		Node curr = queue.poll();

		for (int i = 0; i < 4; i++) {
			int nx = curr.x + dx[i];
			int ny = curr.y + dy[i];

			if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
				continue;
			}

			if (!visited[nx][ny] && map[nx][ny] == 0) {
				queue.offer(new Node(nx, ny));
				visited[nx][ny] = true;
			} else if (!visited[nx][ny] && map[nx][ny] == 1) {
				toMelt.add(new Node(nx, ny));
				visited[nx][ny] = true;
			}
		}
	}

	return toMelt;

}
```

## :black_nib: **Review**
`외곽` 에 있는 치즈 위치를 어떻게 구할지가 계속 고민되서 오래 걸렸는데,
그냥 밖에서 접근할 수 있는 위치가 외곽이래..

## 📡**Link**
- https://www.acmicpc.net/problem/2636

