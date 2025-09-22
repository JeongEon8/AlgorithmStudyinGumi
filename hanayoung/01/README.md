# [백준 - S2] 1260. DFS와 BFS

## ⏰  **time**
30분

## :pushpin: **Algorithm**
bfs, dfs

## ⏲️**Time Complexity**
$O(MlogM+N+M)$

## :round_pushpin: **Logic**
1. 그래프 생성
```java
graph = new ArrayList[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if (graph[start] == null) {
                graph[start] = new ArrayList<>();
            }
            if (graph[end] == null) {
                graph[end] = new ArrayList<>();
            }

            graph[start].add(end);
            graph[end].add(start);
        }
```
2. 정점번호가 작은 것부터 탐색하기 위해 정렬
```java
        for (int i = 0; i < N + 1; i++) {
            if (graph[i] != null) {
                Collections.sort(graph[i]);
            }
        }
```
3. bfs, 하나씩 꺼내면서 sbB에 추가, 방문한 적 없는 노드 큐에 추가 및 방문처리
```java
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];

        q.add(V);
        visited[V] = true;

        while (q.size() > 0) {
            int cur = q.poll();
            sbB.append(cur).append(" ");

            if (graph[cur] != null) {
                for (int next : graph[cur]) {
                    if (visited[next] == false) {
                        q.add(next);
                        visited[next] = true;
                    }
                }
            }
        }
```
4. dfs, sbD에 추가하고, 방문한 적 없는 노드 방문처리하고 dfs 함수 호출, 탐색할 정점없으면 반환
```java
        visited = new boolean[N + 1];
        visited[V] = true;
    static void dfs(int cur, boolean[] visited) {
        sbD.append(cur).append(" ");
        if (graph[cur] == null) {
            return;
        }

        for (int next : graph[cur]) {
            if (visited[next] == false) {
                visited[next] = true;
                dfs(next, visited);
            }
        }
    }
```


## :black_nib: **Review**
- bfs, dfs 기초...오랜만입니다요

## 📡**Link**
- https://www.acmicpc.net/problem/1260
