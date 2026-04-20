# [백준 - S2] 11725. 트리의 부모 찾기 (Easy)

## ⏰ **time**

50분

## :pushpin: **Algorithm**

- 그래프 이론
- 그래프 탐색
- 트리
- 너비 우선 탐색
- 깊이 우선 탐색

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

트리의 노드들의 부모를 찾는 문제였다.
트리를 인접 리스트로 구성한 후, 루트 노드인 1부터 BFS를 수행하였다. 탐색 과정에서 현재 노드와 연결된 방문하지 않은 노드를 큐에 넣으면서, 해당 노드의 부모를 현재 노드로 기록하였다.
이를 반복하여 모든 노드의 부모를 구하였다.

```java
		queue.add(1);
		visited[1] = true;
		while (!queue.isEmpty()) {
			int curr = queue.poll();

			for (int next : adj[curr]) {
				if (!visited[next]) {
					parent[next] = curr;
					queue.add(next);
					visited[next] = true;
				}
			}
		}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/11725
