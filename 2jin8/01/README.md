# [백준 - G3] 4386. 별자리 만들기
 
## ⏰  **time**
20분

## :pushpin: **Algorithm**
MST(최소신장트리)

## :round_pushpin: **Logic**
- 간선 중심의 프루스칼 알고리즘 사용 ⇒ 모든 정점의 간선 정보 저장하기
- 우선순위 큐에 간선의 정보를 저장한 뒤 거리가 작은 것부터 꺼내기
  - 그룹이 1개로 만들어지면 탐색 종료
```java
// Edge 정보 PQ에 넣기 (거리 기준 오름차순 정렬)
PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> Double.compare(e1.dist, e2.dist));
for (int i = 0; i < N - 1; i++) {
  for (int j = i + 1; j < N; j++) {
    double x = Math.abs(stars[i][0] - stars[j][0]);
    double y = Math.abs(stars[i][1] - stars[j][1]);
    double dist = Math.sqrt(x * x + y * y);
    pq.add(new Edge(i, j, dist));
  }
}

double dist = 0.0;
int group = N;
make();
while (!pq.isEmpty()) {
  Edge edge = pq.poll();
  // 서로 다른 집합에 속해있으면 합칠 수 있음
  if (union(edge.u, edge.v)) {
    dist += edge.dist;
    group--;
  }

  // 모든 별이 연결되면 종료
  if (group == 1) break;
}
```

## :black_nib: **Review**
유니온 파인드를 구현할 때 두 집합을 합치는 과정을 빠뜨렸다.. 실수하지 않도록 날림으로 생각하지 않아야 되겠다.

## 📡**Link**
- https://www.acmicpc.net/problem/4386
