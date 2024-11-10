# [백준 - G4] 23835. 어떤 우유의 배달목록 (Easy)

## ⏰ **time**

60분

## :pushpin: **Algorithm**

- 그래프 이론
- 그래프 탐색
- 트리
- 깊이 우선 탐색

## ⏲️**Time Complexity**

$O(NQ)$

## :round_pushpin: **Logic**

시작지점을 root로 가지는 트리를 dfs로 순회하면서 만약 목적지가 있는 경로이면 그 경로에 depth만큼 우유를 주면된다.

```java
	static class Room {
		int milk;
		List<Integer> secretPass;

		public Room() {
			super();
			this.milk = 0;
			this.secretPass = new ArrayList<Integer>();
		}

	}

	static Room[] rooms;
	static boolean[] visited;

	static boolean delivery(int current, int depth, int destination) {
		visited[current] = true;
		if (current == destination) {
			rooms[current].milk += depth;
			return true;
		}
		for (int next : rooms[current].secretPass) {
			if (visited[next])
				continue;
			if (delivery(next, depth + 1, destination)) {

				rooms[current].milk += depth;
				return true;
			}
		}
		return false;
	}

```

## :black_nib: **Review**

예전에 문제를 읽고 고민만 했었는데 이번 B형 특강에서 트리순회를 듣고 사용할 수 있을거 같아서 다시 풀어봤다.

## 📡**Link**

https://www.acmicpc.net/problem/23835
