
# [백준- G4] 1504. 특정한 최단 경로
## ⏰  **time**
60분

## :pushpin: **Algorithm**
최단 거리(플로이드-워셜)

## ⏲️**Time Complexity**
$O(N^3)$

## :round_pushpin: **Logic**

- 가중치를 활용한 최단 거리 문제
- 노드끼리의 최단 거리를 `weight` 배열에 저장하고, 최단거리를 `dis` 배열에 저장한다.
- `v2`, `v1` 두 정점을 무조건 지나야하기 때문에, 아래 두 거리 중 작은 것을 선택한다.
	- `dis[1][v1] + dis[v1][v2] + dis[v2][N]`
	- `dis[1][v2] + dis[v2][v1] + dis[v1][N]`

```java
for (int k = 0; k < N; k++) {
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (dis[i][k] != INF && dis[k][j] != INF) {
				dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
			}
		}
	}
}
		
long path1 = dis[0][v1] + dis[v1][v2] + dis[v2][N - 1];
long path2 = dis[0][v2] + dis[v2][v1] + dis[v1][N - 1];

if (path1 >= INF || path2 >= INF) {
    System.out.println(-1);
} else {
    System.out.println(Math.min(path1, path2));
}
```

## :black_nib: **Review**
- 처음에 `INF`를 `Integer.MAX_VALUE`로 초기화했었는데, 그러면 `path` 계산할 때 `INF + 3 + 5` 처럼 하나라도 최단 거리가 없을 때 오버플로우가 발생해 음수가 된다.
=> 경로가 없을 때 `-1` 을 출력할 수 없음


## 📡**Link**
- https://www.acmicpc.net/problem/1504

