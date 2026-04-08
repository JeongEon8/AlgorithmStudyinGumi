# [백준 - S2] 18352. 특정 거리의 도시 찾기 (Easy)

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 그래프 이론
- 그래프 탐색
- 너비 우선 탐색
- 최단 경로
- 데이크스트라

## ⏲️**Time Complexity**

$O(N * M)$

## :round_pushpin: **Logic**

이 문제는 도시들을 최단거리로 이동했을때, 특정거리의 도시들을 구하는 문제였다. 모든 도로의 가중치가 1로 동일하기 때문에, BFS를 이용해 출발 도시로부터 다른 모든 도시까지의 최단 거리를 구했다.
탐색 과정에서 distances 배열을 -1로 초기화하여 방문 여부와 거리를 동시에 관리했고, 이미 최단 거리가 K에 도달한 도시는 그 이후의 인접 도시를 탐색할 필요가 없으므로 continue를 통해 불필요한 연산을 줄였다.
모든 탐색이 끝난 후 거리가 정확히 K인 도시 번호를 오름차순으로 출력하며, 만약 해당 도시가 없다면 -1을 출력하도록 구현했다.

```java
		while (!queue.isEmpty()) {
			int curr = queue.poll();

			if (distances[curr] >= K) {
				continue;
			}

			for (int next : list[curr]) {
				if (distances[next] == -1) {
					distances[next] = distances[curr] + 1;
					queue.add(next);
				}
			}
		}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/18352
