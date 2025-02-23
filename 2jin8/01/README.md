# [백준- G3] 1516. 게임 게발
 
## ⏰  **time**
40분

## :pushpin: **Algorithm**
위상 정렬

## ⏲️**Time Complexity**
$O((N + E) log N)$

## :round_pushpin: **Logic**
- 진입 차수가 0인 것 큐에 넣기
- 해당 건물과 연결된 간선 끊기
  - 마찬가지로 진입 차수가 0이 되면 큐에 넣고 소요 시간 측정
```java
while (!pq.isEmpty()) {
  int now = pq.poll().idx;

  for (int next : graph[now]) {
    if (--inDegree[next] == 0) {
      times[next] += times[now];
      pq.offer(new Building(next, times[next]));
    }
  }
}
```

## :black_nib: **Review**
항상 예외를 생각하고 풀자

## 📡**Link**
- https://www.acmicpc.net/problem/1516
