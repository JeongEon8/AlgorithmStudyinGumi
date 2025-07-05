# [백준- G4] 1753. 최단경로
 
## ⏰  **time**
50분

## :pushpin: **Algorithm**
다익스트라

## ⏲️**Time Complexity**
$O((V + E) * log V)$

## :round_pushpin: **Logic**
- 가장 가까운 정점을 찾기 위해 PriorityQueue를 사용
- 다익스트라 알고리즘으로 현재 노드까지의 거리가 저장된 거리보다 크면 무시
- 더 짧은 경로 발견 시 업데이트 및 큐에 추가
```java
while (!pq.isEmpty()) {
	int[] current = pq.poll();
	int currNode = current[0];
	int currDist = current[1];

	// 현재 노드까지의 거리가 저장된 거리보다 크면 무시
	if (currDist > node[currNode]) continue;

	// 인접한 노드를 확인하며 최단 거리 갱신
	for (int[] neighbor : list[currNode]) {
		int nextNode = neighbor[0];
		int weight = neighbor[1];
		int newDist = currDist + weight;

		// 더 짧은 경로 발견 시 업데이트 및 큐에 추가
		if (newDist < node[nextNode]) {
			node[nextNode] = newDist;
			pq.offer(new int[] { nextNode, newDist });
		}
	}
}
```

## :black_nib: **Review**
- Priority Queue를 사용하니 해결 시간이 단축되는 것을 확인했습니다.

## 📡**Link**
- https://www.acmicpc.net/problem/1753
