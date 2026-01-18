# [백준 - 골드 4] 1197. 최소 스패닝 트리

## ⏰**time**
28분

## :pushpin: **Algorithm**
- 최소 스패닝 트리 (MST)
- 프림 알고리즘 (Prim's Algorithm)
- 우선순위 큐 (Priority Queue)

## ⏲️**Time Complexity**
$O(E \log V)$

## :round_pushpin: **Logic**
1. 인접 리스트를 사용하여 무방향 그래프를 표현합니다.
```
edges = new ArrayList[V + 1];
for (int i = 0; i < E; i++) {
    int A = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());
    
    edges[A].add(new Edge(B, C));
    edges[B].add(new Edge(A, C));
}
```

2. 1번 노드를 시작점으로 하여 MST 구성을 시작합니다. 시작 노드의 모든 인접 간선을 우선순위 큐에 추가합니다.
```
visited[1] = true;
for (Edge e : edges[1]) {
    pq.offer(e);
}
```

3. 우선순위 큐에서 가중치가 가장 작은 간선을 선택합니다. 해당 간선의 도착 노드가 이미 방문한 노드라면 건너뜁니다.
```
while (!pq.isEmpty() && visitedCount < V) {
    Edge e = pq.poll();
    if (visited[e.v]) continue;
    
    visited[e.v] = true;
    visitedCount++;
    answer += e.w;
}
```

4. 새로 방문한 노드의 모든 인접 간선 중 아직 방문하지 않은 노드로 가는 간선들을 우선순위 큐에 추가합니다.
```
for (Edge nextEdge : edges[e.v]) {
    if (!visited[nextEdge.v]) {
        pq.offer(nextEdge);
    }
}
```

5. 모든 노드를 방문할 때까지 반복하며, 선택한 간선의 가중치 합을 출력합니다.

## :black_nib: **Review**
- 크루스칼 알고리즘으로도 풀이가 가능하다.

## 📡 Link
https://www.acmicpc.net/problem/1197
