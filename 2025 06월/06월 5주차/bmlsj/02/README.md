# [백준 - S2] 11724. 연결 요소의 개수
 
## ⏰  **time**
15분

## :pushpin: **Algorithm**
DFS

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
- 그래프의 연결 요소 개수를 찾는 문제
- 모든 정점을 순회하면서, 방문하지 않은 정점을 발견하면 DFS를 시작
- DFS가 한 번 완료되면, `cnt + 1`


```java
public static void connect(int node) {

		visited[node] = true;

		for (int next : graph[node]) {
			if (!visited[next]) {
				visited[next] = true;
				connect(next);
			}
		}
	}
```

## :black_nib: **Review**
- 방향이 없는 그래프여서, `graph[u]`에 `v`를, `graph[v]`에 `u`를 모두 추가해야 한다.


## 📡**Link**
- https://www.acmicpc.net/problem/11724
