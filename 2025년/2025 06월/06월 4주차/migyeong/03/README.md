# [백준- G5] 1916. 최소비용 구하기
 
## ⏰  **time**
40분

## :pushpin: **Algorithm**
- 다익스트라

## ⏲️**Time Complexity** 
O((N+M)logN)

## :round_pushpin: **Logic**
- 다익스트라 알고리즘 사용을 위해 마을에 초기 비용을 최대로 설정
- PriorityQueue를 사용해서 도시 비용을 기준으로 우선 순위 정렬
- 버스를 이용했을 때 더 낮은 비용으로 도시에 도착하면 값을 변경
- 목표 위치에 도착하면 다익스트라 함수 종료

``` java
dist = new int[N + 1]; // 배열로 최소 비용 관리
Arrays.fill(dist, Integer.MAX_VALUE);

private static void dijkstra(int start) {

    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[1])); // 도시 비용을 기준으로 우선 순위
    pq.offer(new int[]{start, 0});
    dist[start] = 0;

    while (!pq.isEmpty()) {
        int[] temp = pq.poll();
        int city = temp[0];
        int cost = temp[1];

        if (dist[city] < cost) continue; // 이미 더 짧은 거리로 방문한 경우

        for (int[] next : graph[city]) {
            int nextCity = next[0];
            int nextCost = cost + next[1];

            if(nextCost < dist[nextCity]) {
                dist[nextCity] = nextCost;
                pq.offer(new int[] {nextCity, nextCost});
            }
        }
    }
}
```


## :black_nib: **Review**
그래프 익숙해지는데 오래 걸릴 것 같아요..

## 📡**Link**
- https://www.acmicpc.net/problem/1916
