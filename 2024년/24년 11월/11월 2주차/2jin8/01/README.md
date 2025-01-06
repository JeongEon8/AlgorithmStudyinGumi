# [백준- G4] 12851. 숨바꼭질 2
 
## ⏰  **time**
1시간

## :pushpin: **Algorithm**
BFS

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
- 기존에 풀었던 숨바꼭질 문제와 달리 K까지 최단거리로 도착할 수 있는 수를 구해야 함
- 만약 방문한 곳이 K이면 방문할 수 있는 경우의 수를 증가하기
  - 방문할 수 있는 경우가 0이 아니라면 최단 경로일 때를 이미 찾았으므로 그 이후를 탐색할 필요가 없음
  - 따라서 큐에 있는 모든 위치를 탐색한 뒤 종료하기
- 방문한 위치를 큐에 넣고 바로 방문처리하면 여러 경우를 고려할 수 없음
   - ex) `1 → 2 → 3 → 6 → 7 → 14`, `1 → 2 → 4 → 8 → 7 → 14`
     - 위치 7을 두 번 큐에 넣어야 하는데 이미 방문 처리를 하면 나머지 경우를 셀 수 없음
  - 따라서 방문 처리할 위치를 기록한 뒤, 한 레벨이 끝날 때마다 수행하기
```java
	static void bfs(int N, int K) {
		Queue<Integer> queue = new ArrayDeque<>();
		visited[N] = true;
		queue.offer(N);

		int cnt = 0, minTime = 0;
		HashSet<Integer> visitedList = new HashSet<>();
		while (!queue.isEmpty()) {
			minTime++;
			visitedList.clear();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int now = queue.poll();

				int next = now - 1;
				if (next == K) cnt++;
				else if (next >= 0 && !visited[next]) {
					queue.offer(next);
					visitedList.add(next);
				}

				next = now + 1;
				if (next == K) cnt++;
				else if (next < MAX && !visited[next]) {
					queue.offer(next);
					visitedList.add(next);
				}

				next = now * 2;
				if (next == K) cnt++;
				else if (next < MAX && !visited[next]) {
					queue.offer(next);
					visitedList.add(next);
				}
			}
			
			// 최단 거리를 찾으면 종료하기
			if (cnt != 0) break;
			
			// 한 레벨에서 만들 수 있는 모든 수를 큐에 넣은 후 방문 처리하기
			// 1 - 2 - 4 - 8 - 7 - 14
			// 1 - 2 - 3 - 6 - 7 - 14
			// 7을 2번 큐에 넣어줘야 하므로!
			for (int v : visitedList) {
				visited[v] = true;
			}
		}
		System.out.println(minTime);
		System.out.println(cnt);
	}
```

## :black_nib: **Review**
방문할 때마다 방문 처리를 하면 추가적인 경우를 찾지 못하는 경우가 있었다. 무조건적으로 큐에 넣을 때 방문 처리를 하면 안된다는 것을 알게 되었다.

## 📡**Link**
- https://www.acmicpc.net/problem/12851
