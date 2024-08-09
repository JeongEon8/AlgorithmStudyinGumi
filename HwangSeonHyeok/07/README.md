# [백준 - G4] 12851. 숨바꼭질 2

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 그래프 이론
- 그래프 탐색
- 너비 우선 탐색

## ⏲️**Time Complexity**

$O(n^2)$

## :round_pushpin: **Logic**

bfs로 목적지까지 탐색을 하나 bfs에서 같은 거리를 탐색 할 땐 중복탐색이 가능해야하므로 큐에 들어갈 때가 아니라 큐에서 꺼낼 때 visited를 체크해줘야한다.

```java

static void bfs(int start, int to) {
		Queue<Finding> q = new ArrayDeque<>();
		q.add(new Finding(start, 0));
		while (!q.isEmpty()) {
			Finding current = q.poll();
			visited[current.x] = true;
			if (current.x == to) {
				if (ansTime < current.time) {
					return;
				} else {
					cnt++;
					ansTime = current.time;
				}
			} else {
				if (current.x + 1 <= 140000 && !visited[current.x + 1]) {
					q.add(new Finding(current.x + 1, current.time + 1));
				}
				if (current.x - 1 >= 0 && !visited[current.x - 1]) {
					q.add(new Finding(current.x - 1, current.time + 1));
				}
				if (current.x * 2 <= 140000 && !visited[current.x * 2]) {
					q.add(new Finding(current.x * 2, current.time + 1));
				}
			}

		}

	}
```

## :black_nib: **Review**

수업시간의 실습으로 푼 1697.숨바꼭질의 시리즈 문제.  
최단 경로의 탐색의 시간과 최단 경로의 수를 모두 물어보는 특이한 문제였다.  
bfs에서 큐에 삽입할 때 visited를 체크 하는 것을 큐에서 빼낼 때 체크해야한다는 아이디어가 필요하다.

## 📡**Link**

- https://www.acmicpc.net/problem/12851
