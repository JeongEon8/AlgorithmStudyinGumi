# [백준 - G5] 15591. MooTube (Silver)
 
## ⏰  **time**
60분

## :pushpin: **Algorithm**
BFS

## ⏲️**Time Complexity**
$O(N+E)$


## :round_pushpin: **Logic**
- BFS를 통해 usado가 k 이상인 경우에 트리를 탐색


```java
   static int moo(int start, int k) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[graph.length];
        int count = 0;

        visited[start] = true;
        q.add(start);

        while (!q.isEmpty()) {
            int now = q.poll();
            for (Node next : graph[now]) {
                if (!visited[next.to] && next.cost >= k) {
                    visited[next.to] = true;
                    q.add(next.to);
                    count++;
                }
            }
        }

        return count;
    }
```

## :black_nib: **Review**
- 인접 행렬로 구현하기에 정점 수가 너무 많기에 인접 리스트로 구현해야함

## 📡**Link**
- https://www.acmicpc.net/problem/15591
