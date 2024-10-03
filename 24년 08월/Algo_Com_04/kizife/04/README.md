# [백준] 1260. DFS와 BFS 
 
## ⏰  **time**
20분 

## :pushpin: **Algorithm**
구현

## ⏲️**Time Complexity**
524ms

## :round_pushpin: **Logic**
dfs와 bfs 활용이다. 
```java
// BFS 탐색
	static void bfs(int V) {
		Queue<Integer> queue = new LinkedList<Integer>();  // BFS를 위한 큐
		queue.offer(V);  // 시작 정점을 큐에 삽입
		visit[V] = true;  // 시작 정점을 방문 처리

		System.out.print(V + " ");  // 시작 정점 출력

		// 큐가 빌 때까지 탐색하기
		while (!queue.isEmpty()) {
			int n = queue.poll();  // 큐에서 정점을 꺼내기

			// 인접한 정점들을 탐색
			for (int i = 1; i < arr.length; i++) {
				if (arr[n][i] == 1 && !visit[i]) {  // 연결된 정점이면서 방문하지 않은 경우
					visit[i] = true;  // 방문 처리하고 
					System.out.print(i + " ");  // 정점 출력
					queue.offer(i);  // 큐에 삽입
				}
			}
		}
	}
```

```java
	// DFS 탐색 함수
	static void dfs(int V) {
		visit[V] = true;  // 현재 정점 방문 처리
		System.out.print(V + " ");  // 현재 정점 출력

		// 인접한 정점들을 탐색
		for (int i = 1; i < arr.length; i++) {
			if (arr[V][i] == 1 && !visit[i]) {  // 연결된 정점이면서 방문하지 않은 경우
				dfs(i);  // DFS 계속 진행
			}
		}
	}
```


## :black_nib: **Review**
- dfs, bfs 연습용으로 좋았다. 그치만 bfs는 여전히 낯설다...

## 📡**Link**
- https://www.acmicpc.net/problem/1260 
