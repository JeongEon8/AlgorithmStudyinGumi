# [백준 - G4] 1967. 트리의 지름 (Easy)

## ⏰ **time**

50분

## :pushpin: **Algorithm**

- 그래프 이론
- 그래프 탐색
- 트리
- 깊이 우선 탐색
- 트리의 지름

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

루트 노드에서 가장 먼 거리의 노드를 구한 다음, 그 노드에서 가장 먼 노드의 길이를 출력했다.

```java
	public static void main(String[] args) throws Exception {

		...

		maxLength = 0;
		visited = new boolean[N + 1];
		dfs(1, 0);

		maxLength = 0;
		visited = new boolean[N + 1];
		dfs(furthestNode, 0);

		System.out.println(maxLength);
	}

	public static void dfs(int current, int distance) {
		visited[current] = true;
		if (maxLength < distance) {
			maxLength = distance;
			furthestNode = current;
		}

		for (Node node : adj[current]) {
			if (!visited[node.target]) {
				dfs(node.target, distance + node.weight);
			}
		}
	}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/1967
