# [백준 - 골드 4] 1922. 네트워크 연결

## ⏰  **time**

1시간

## :pushpin: **Algorithm**
mst(최소 스패닝 트리)

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
1. 우선순위큐를 이용하여 cost가 작은 순으로 정렬한다.
2. 1부터 시작하여 node 1과 연결된 모든 노드 중 cost가 가장 작은 node를 탐색한다. 이떄, cost는 result에 더한다.
3. 계속해서 탐색 후 결과값을 출력한다.
```cpp
int prim() {
	priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
	int result = 0;
	pq.push({ 0, 1 });
	for (int i = 1; i <= N; i++) {
		while (!pq.empty() && visited[pq.top().second]) {
			pq.pop();
		}
		int next = pq.top().second;
		int minCost = pq.top().first;
		visited[next] = true;
		result += minCost;
		for (auto o : node[next]) {
			pq.push({ o.second, o.first });
		}
	}

	return result;
}
```

## :black_nib: **Review**
- mst 문제 처음봤다.

## 📡 **URL**
https://www.acmicpc.net/problem/1922
