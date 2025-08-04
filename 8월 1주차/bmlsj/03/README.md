
# [백준- G4] 2573. 빙산
## ⏰  **time**
60분

## :pushpin: **Algorithm**
BFS

## ⏲️**Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**

1. 빙산의 덩어리 수를 세어, 
  - 1개면 로직을 계속 수행 
  - 0 이면 0을 출력 
  - 2 이상이면 `year`를 출력하고 멈춘다.
2. 얼음 주변의 바다의 수를 `count` 배열에 저장해, 그만큼 `map`을 녹인다.
2. 녹인 `map`의 덩어리 수를 센다.
3. `year`를 1 증가시키고, 다시 1번부터 반복

```java
int year = 0;
while (true) {
	int cnt = countArea();
	if (cnt == 0) {
		System.out.println(0);
		break;
	}
	if (cnt >= 2) {
		System.out.println(year);
		break;
	}
	ices = meltingIce(ices);  // 다음 녹일 얼음 위치를 갱신
	year++;
}
```

</br>

```java
static Queue<Node> meltingIce(Queue<Node> queue) {

	Queue<Node> nextIces = new ArrayDeque<>();

	while (!queue.isEmpty()) {

		Node curr = queue.poll();
		int cnt = 0;

		for (int i = 0; i < 4; i++) {

			int nx = curr.x + dx[i];
			int ny = curr.y + dy[i];

			if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
				continue;
			}

			if (map[nx][ny] == 0) {
				cnt++;
			}
		}

		count[curr.x][curr.y] = cnt;
	}
	// 얼음 녹이기
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (map[i][j] > 0) {
				map[i][j] -= count[i][j];
				if (map[i][j] < 0)
					map[i][j] = 0;
				if (map[i][j] > 0) {  // 다음 녹일 얼음 위치
					nextIces.offer(new Node(i, j));
				}
			}
		}
	}
		
	return nextIces;
}
```

## :black_nib: **Review**
- 얼음 위치를 저장한 큐 `ices` 를 로직을 수행할 때마다 갱신해줘야하는 것을 잊어 시간초과가 발생했다.

## 📡**Link**
- https://www.acmicpc.net/problem/2573

