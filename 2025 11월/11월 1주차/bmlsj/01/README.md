
# [백준- G4] 1967. 트리의 지름

## ⏰  **time**
1시간

## :pushpin: **Algorithm**
DFS

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**

1. 1번 노드에서 DFS를 돌며 가장 멀리 떨어진 노드를 찾는다.
2. 첫 DFS로 구한 `farthestNode`를 시작점으로 두 번째 DFS를 수행한다.
3. 이번에는 "그 노드로부터 가장 멀리 있는 노드까지의 거리" `maxDist`를 구한다.

```java
visited = new boolean[n + 1];
tree(1, 0); // 1번 노드에서 가장 먼 노드 찾기

visited = new boolean[n + 1];
maxDist = 0;
tree(farthestNode, 0); // 그 노드에서 다시 DFS
```

```java
static void tree(int v, int dist) {

	visited[v] = true;
	if (dist > maxDist) {
		maxDist = dist;
		farthestNode = v;
	}

	for (Node node : graph[v]) {
		if (!visited[node.node]) {
			tree(node.node, dist + node.weight);
		}
	}
}
```


## :black_nib: **Review**

## 📡**Link**
- https://www.acmicpc.net/problem/1967

