# [백준- G4] 18223. 민준이와 마산 그리고 건우
 
## ⏰  **time**
20분

## :pushpin: **Algorithm**
최단경로 (다익스트라)

## ⏲️**Time Complexity**
$O((V + E) log V)$

## :round_pushpin: **Logic**
- 최단경로에 건우가 있는 곳이 포함되는지 확인해야 함
- 건우가 있는 곳을 거쳐갈 때의 최단 거리가 출발지부터 도착지까지의 최단 거리보다 크면 갈 수 없는 것
  - 최단거리 1: 출발지 → 도착지
  - 최단거리 2: 출발지 → 건우가 있는 곳 → 도착지
  - `최단거리 1 < 최단거리 2`라면 최단 경로에 건우가 있는 곳이 포함되지 않음
```java
int dist1 = dijkstra(1, V); // 정점 1에서 V까지의 최단 거리
int dist2 = dijkstra(1, P) + dijkstra(P, V); // 건우가 위치한 정점을 지나갈 때의 최단 거리
System.out.println(dist1 < dist2? "GOOD BYE" : "SAVE HIM");
```

## :black_nib: **Review**
최단경로 오랜만이라 정렬하는걸 까먹었다 ㅎㅎ... 문제를 많이 풀자

## 📡**Link**
- https://www.acmicpc.net/problem/18223
