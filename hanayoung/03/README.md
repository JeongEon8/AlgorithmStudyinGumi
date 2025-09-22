# [백준 - G4] 1707. 이분 그래프

## ⏰  **time**
90분

## :pushpin: **Algorithm**
bfs

## ⏲️**Time Complexity**
$O(K × (V + E))$

## :round_pushpin: **Logic**
1. 그래프 생성
```java
               if (graph[u] == null) {
                    graph[u] = new ArrayList<>();
                }
                if (graph[v] == null) {
                    graph[v] = new ArrayList<>();
                }
                graph[u].add(v);
                graph[v].add(u);
```
2. 정점들 탐색, 방문한 적 없으면(visited[i] == 0), 큐에 추가하고 1로 값 지정.
3. 큐를 돌며 연결된 노드들 탐색, 방문한 적 없으면 cur의 반대 색상(*-1)로 업데이트하고 큐에 추가
4. 둘의 색상이 같다면 이분 그래프가 아니므로 "NO" 설정하고 탈출
```java
            for (int i = 1; i <= V; i++) {
                if (visited[i] == 0) {
                    q.add(i);
                    visited[i] = 1;
                    while (q.size() > 0) {
                        int cur = q.poll();
                        if (graph[cur] != null) {
                            for (int node : graph[cur]) {
                                if (visited[node] == 0) {
                                    visited[node] = visited[cur] * -1;
                                    q.add(node);
                                } else if (visited[node] == visited[cur]) {
                                    answer = "NO";
                                    q.clear();
                                    break;
                                }
                            }
                        }
                    }
                }
            }
```



## :black_nib: **Review**
- 이분 그래프가 뭔디.. 정점 색 달라지게 하는 걸로 푸는 거 첨 알았네 잉.. 정점으로 돌 생각도 못했움..

## 📡**Link**
- https://www.acmicpc.net/problem/1707
