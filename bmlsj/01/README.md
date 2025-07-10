# [백준 - G4] 1707. 이분 그래프

## ⏰  **time**
40분

## :pushpin: **Algorithm**
BFS

## ⏲️**Time Complexity**
$O(V+E)$

## :round_pushpin: **Logic**

- **이분 그래프** : 정점을 2그룹으로 나누되, 같은 그룹의 정점끼리는 간선으로 이어지지 않은 경우

- BFS 풀이
    - `colors`가 `visited` 배열의 역할을 하므로, 따로 선언할 필요가 없다.

1. 시작점을 빨간색으로 표시(숫자 1)
2. 시작점의 인접한 점들을 모두 파란색으로 표시(-1)
3. 인접한 점의 인접점들을 빨간색으로 표시(1)
4. 1 ~ 3번을 반복해, 색을 모두 칠한다.
5. 색을 칠하다 이웃이 같은 색이라면, 이분 그래프가 될 수 없다.

</br>

```java
static boolean bfs(int start) {

	Queue<Integer> queue = new ArrayDeque<Integer>();
	queue.add(start);
	colors[start] = 1; // 시작은 빨간색 1

	while (!queue.isEmpty()) {

		int v = queue.poll();

		for (int nv : graph[v]) {
			if (colors[nv] == colors[v])
				return false;

			if (colors[nv] == 0) {
				colors[nv] = -colors[v]; // 인접은 -1
				queue.add(nv);
			}
		}
	}

	return true;

}
```

## :black_nib: **Review**
이분 그래프 개념만 잘 알면 바로 풀 수 있을 것 같다.

## 📡 Link
https://www.acmicpc.net/problem/1707