# [백준 - 골드 4] 1647. 도시 분할 계획
 
## ⏰  **time**
이틀

## :pushpin: **Algorithm**
mst 프림알고리즘

## ⏲️**Time Complexity**
$O(NlogN)$

## :round_pushpin: **Logic**
1. prim 알고리즘
     - 초기 위치를 잡고 Priority_Queue를 이용하여 최소 경비를 고른다.
     - 만약 이미 방문한 경우라면 경비를 포함하지 않는다.
   ```cpp
  int prim() {
  	priority_queue <pair<int, int>, vector<pair<int, int>>, greater<pair<int, int >>> pq;
  	int result=0;
  	int maxCost = 0;
  	pq.push( { 0,1 });
  
  	for (int i = 1; i <= n; i++) {
  		while (!pq.empty() &&visited[pq.top().second]) {
  			pq.pop();
  		}
  		int next = pq.top().second;
  		int minCost = pq.top().first;
  		maxCost = max(maxCost, minCost);
  		visited[next] = true;
  		result += minCost;
  		for (auto o : edge[next]) {
  			pq.push({ o.second,o.first });
  		}
  	}
  	return result-maxCost;
  }
   ```

## :black_nib: **Review**
- 힝.. 내가 원래 만든 코드는 왜 안되구 이건 되는거야ㅠㅠ 비슷한데ㅠㅠ

## 📡 Link
https://www.acmicpc.net/problem/1647
