# [백준 - S1] 15900. 나무 탈출

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 그래프 이론
- 그래프 탐색
- 트리
- 깊이 우선 탐색

## ⏲️**Time Complexity**

$O(NM)$

## :round_pushpin: **Logic**

리프 노드들의 깊이의 합이 홀수면 성원이가 이기고 짝수면 진다.
루트 노드 1에서부터 dfs로 각 리프 노드들의 차수를 구하였다.

```java
	static Node[] nodes;
	static boolean[] visited;
	static int ans;

	static class Node {
		int num;
		List<Integer> roots = new ArrayList<>();

		public Node(int num) {
			super();
			this.num = num;
		}

	}

	static void dfs(int current, int depth) {
		visited[current] = true;
		boolean isLeaf = true;

		for (int next : nodes[current].roots) {
			if (!visited[next]) {
				isLeaf = false;
				dfs(next, depth + 1);
			}
		}
		if (isLeaf) {
			ans += depth;

		}

	}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/15900
