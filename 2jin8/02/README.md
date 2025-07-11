# [백준- G4] 16562. 친구비
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
DFS

## ⏲️**Time Complexity**
$O(N + M)$

## :round_pushpin: **Logic**
- "친구의 친구는 친구" → DFS 탐색을 통해 한 친구와 연결되어 있는 친구 탐색하기
  - 친구를 탐색할 때, 해당 친구에게 줘야하는 친구비 중 최솟값 찾기
  - 그 최솟값만큼만 주는 것이 친구로 만드는 최소 비용
- 모든 친구를 다 탐색할 때 까지 반복하기
```java
// 친구의 친구 탐색하기
static void dfs(int now) {
    minCost = Math.min(minCost, friendCosts[now]); // 최소 비용 갱신
    visited[now] = true;

    for (int next : graph[now]) {
        if (visited[next]) continue;

        dfs(next);
    }
}
```

## :black_nib: **Review**
간단한 DFS 문제였다

## 📡**Link**
- https://www.acmicpc.net/problem/16562
