# [백준 - S1] 1389. 케빈 베이컨의 6단계 법칙
 
## ⏰  **time**
60분

## :pushpin: **Algorithm**
BFS

## ⏲️**Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**

- 각 노드에서의 모든 노드들과의 최단 거리를 탐색
- 시작점 `x`에서 도착점 `target`에 도착할때까지의 `dis`를 BFS로 탐색하였음



```java
public static int connect(int x, int target) {

	Queue<int[]> queue = new ArrayDeque<int[]>();
	visited[x] = true;
	queue.add(new int[] { x, 0 });

	while (!queue.isEmpty()) {

		int[] q = queue.poll();
		x = q[0];
		int dis = q[1];

		for (int nx : friend[x]) {

			if (nx == target) {
				return dis;
			}

			if (!visited[nx]) {
				visited[nx] = true;
				queue.add(new int[] { nx, dis + 1 });
			}
		}
	}

	return -1;
}
```

## :black_nib: **Review**
 * 각 노드별 거리를 배열에 다가 저장해놓으면, 매번 BFS 탐색을 하지 않아도 될지도..



## 📡**Link**
- https://www.acmicpc.net/problem/1389
