# [백준 - S3] 10451. 순열 사이클
 
## ⏰  **time**
15분

## :pushpin: **Algorithm**
DFS

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**

- 1번부터 N번까지 순차적으로 방문하면서 방문하지 않은 노드에서 DFS를 수행
- DFS를 통해 순열의 한 사이클을 모두 방문하고, 카운트를 1 증가
- 모든 순열의 사이클 개수를 출력


```java
public static void cycle(int v) {

	visited[v] = 1;

	if (visited[per[v]] == 0) {
		cycle(per[v]);
	}

}
```

## :black_nib: **Review**
- 1번 ~ N번 노드여서 각 배열의 크기를 N+1로 해야한다. 
크기 조금 헷갈리지도..

## 📡**Link**
- https://www.acmicpc.net/problem/10451
