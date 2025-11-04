# [백준 - G3] 2623. 음악프로그램

## ⏰  **time**
60분

## :pushpin: **Algorithm**
위상정렬, queue

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**

차수를 활용해야 한다. 
1. 차수가 0이면 큐에 넣고 연결된 노드의 차수를 `-1` 해준다.
2. 만약 다음 노드의 차수가 0이 되면, 큐에 넣고 이 작업을 반복한다.


```java
Queue<Integer> queue = new ArrayDeque<Integer>();
List<Integer> result = new ArrayList<Integer>();

for (int i = 0; i <= N; i++) { // 차수가 0인 노드만 queue에
	if (degree[i] == 0)
		queue.add(i);
}

while (!queue.isEmpty()) {

	int cur = queue.poll();
	result.add(cur);

	for (int next : graph[cur]) {
		degree[next]--;
		if (degree[next] == 0) {
			queue.add(next);
		}
	}
}
```


## :black_nib: **Review**

처음에 트리의 차수처럼 생각했는데 그래프의 차수로 생각해야 한다.
예제를 예시로 한다면
`{ 1 : 0, 2 : 1, 3 : 2, 4 : 2, 5 : 1, 6 : 0}` 이 된다.

## 📡**Link**
- https://www.acmicpc.net/problem/2623
