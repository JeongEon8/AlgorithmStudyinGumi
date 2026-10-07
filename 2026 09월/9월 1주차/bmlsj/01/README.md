# [PGS - LV3] 01\_부대복귀

## ⏰**time**

30분

## :pushpin: **Algorithm**

BFS

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

무방향 그래프이므로, `destination`에서 1번만 BFS 수행해 모든 지역까지의 최단 거리를 미리 구한 후 `source` 배열의 결과만 조회

```java
static int bfs(int source, int destination) {

        Queue<int[]> pq = new ArrayDeque<>();
        boolean[] visited = new boolean[graph.length];

        visited[source] = true;
        pq.add(new int[]{source, 0});

        while(!pq.isEmpty()) {

            int[] curr = pq.poll();
            int area = curr[0];
            int cnt = curr[1];

            if (area == destination) {
                return cnt;
            }

            for (int next: graph[area]) {
                if (!visited[next]) {
                    visited[next] = true;
                    pq.add(new int[]{next, cnt + 1});
                }
            }

        }

        return -1;

    }
```

## :black_nib: **Review**

## 📡 Link

<https://school.programmers.co.kr/learn/courses/30/lessons/132266?gad_source=1&gad_campaignid=23037984604&gbraid=0AAAAAC_c4nB3sA9Dsj-9w05ijvmdSNsSW&gclid=Cj0KCQjwteTUBhD4ARIsAEYjs3qcTH-K2sBdmoVJbRc-p8FI136CsjFNMCybTJ89a94W3i5bkDnp4ggaAt3pEALw_wcB>
