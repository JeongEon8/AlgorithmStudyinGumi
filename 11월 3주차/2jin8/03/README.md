# [백준- G3] 1719. 택배
 
## ⏰  **time**
40분

## :pushpin: **Algorithm**
최단 경로

## ⏲️**Time Complexity**
$O(V(V+E)logV)$

## :round_pushpin: **Logic**
- 각 집하장에서 다른 집하장까지의 최단 경로를 구해야 함
  - 다익스트라 알고리즘 or 플로이드 와셜 알고리즘을 사용해서 최단 경로 구하기
  - 현재 집하장에 오기 바로 전의 집하장 정보도 함께 기록하기
- 경로를 거슬러서 가장 먼저 거쳐야 하는 집하장인 경우 기록하기
  - 출발지: route[start] = start
  - 따라서 `next = route[now]`일 때, `route[next] == next`라면 현재 집하장이 가장 먼저 거쳐야 하는 집하장
```java
for (int i = 1; i <= N; i++) {
  Arrays.fill(minDist, INF);
  Arrays.fill(path, 0);
  Arrays.fill(visited, false);

  dijkstra(i);
  for (int j = 1; j <= N; j++) {
    if (i == j) continue;

    int now = j;
    while (true) {
      int next = path[now];
      // 현재 집하장이 가장 먼저 거쳐야 하는 집하장인 경우 
      if (next == path[next]) { 
        route[i][j] = now;
        break;
      }
      now = next;
    }
  }
}

StringBuilder sb = new StringBuilder();
for (int i = 1; i <= N; i++) {
  for (int j = 1; j <= N; j++) {
    if (i == j) sb.append("-").append(" ");
    else sb.append(route[i][j]).append(" ");
  }
  sb.append("\n");
}
System.out.println(sb);
```

## :black_nib: **Review**
경로를 기록하는 것은 다른 문제와 같았지만 시작점이 아닌 시작점 바로 다음점을 구해야 한다는 것이 달랐다. 반복문에서 잘 계산하도록 해야 할 듯

## 📡**Link**
- https://www.acmicpc.net/problem/1719
