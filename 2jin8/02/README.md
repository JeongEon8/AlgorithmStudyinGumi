# [백준 - G3️] 1238. 파티
 
## ⏰  **time**
45분

## :pushpin: **Algorithm**
최단 경로

## :round_pushpin: **Logic**
- 모든 정점에서 X까지의 최단 경로 구하기 ⇒ 최단 경로 알고리즘 사용하기
- X를 제외한 모든 정점에서 X까지 가오고 가는데 걸리는 시간 구하기
  - `time = dist[i][x] + dist[x][i]`
  - 오고 가는데 걸린 시간 중 최대 시간보다 크다면 갱신하기
```java
// 각 정점에서 모든 정점까지 소요 시간 구하기
for (int i = 1; i <= N; i++) {
  dist[i] = dijkstra(i).clone();
}

int maxTime = 0;
for (int i = 1; i <= N; i++) {
  if (i == X)
    continue;
  int time = dist[i][X] + dist[X][i];
  if (time > maxTime)
    maxTime = time;
}
```

## :black_nib: **Review**
아 그 사이 최단 경로 알고리즘 까먹어서 이상한 코드를 짰다..ㅎ 다시 개념 복습을 해야 되겠다.

## 📡**Link**
- https://www.acmicpc.net/problem/1238
