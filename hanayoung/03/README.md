# [백준 - G5] 15591. MooTube(Silver)

## ⏰  **time**
60분

## :pushpin: **Algorithm**
BFS

## ⏲️**Time Complexity**
$O(N²)$

## :round_pushpin: **Logic**
1. USADO를 담을 배열 생성 및 처음에 주어진 USADO 값 담을 리스트 생
```java
        int[][] usado = new int[N + 1][N + 1];
        List<Integer>[] given = new ArrayList[N+1];

            if(given[p] == null) given[p] = new ArrayList<>();
            given[p].add(q);
            if(given[q] == null) given[q] = new ArrayList<>();
            given[q].add(p);
            usado[p][q] = r;
            usado[q][p] = r;
```
2. 주어진 Q만큼 탐색하며, v값과 연결된 노드부터 탐색하며 큐에 삽입 후 방문처리
3. 해당 노드와 연결된 노드들 탐색하며, 방문한 적 없고 처음 시작값과 다르면 최소 USADO와 현재 탐색 중인 노드와 그와 연결된 노드 사이의 USADO의 최솟값을 비교해서 업데이트, 방문 처리 및 큐 삽입
```java
                for(int m: given[v]) {
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{m, usado[v][m]}); // 다음 노드와 그 사이의 최소 usado
                    boolean[] visited = new boolean[N+1];
                    visited[m] = true;
                    while(q.size() > 0) {
                        int[] cur = q.poll();
                        for(int n: given[cur[0]]) {
                            if(visited[n] == false && v != n) {
                                int min = Math.min(cur[1], usado[cur[0]][n]);
                                usado[v][n] = min;
                                usado[n][v] = usado[v][n];
                                visited[n] = true;
                                q.add(new int[]{n, min});
                            }
                        }
                    }
                }
```
3. usado를 돌며 k보다 같거나 큰 값 찾아서 answer++
```java
            for(int j = 1; j < N+1; j++) {
                if(usado[v][j] >= k && v != j) answer++;
            }
```


## :black_nib: **Review**
- 우당탕탕 돌아갔던 문제.. 시간초과는 면했다만 더 나은 방법은 없으려나

## 📡**Link**
- https://www.acmicpc.net/problem/15591
