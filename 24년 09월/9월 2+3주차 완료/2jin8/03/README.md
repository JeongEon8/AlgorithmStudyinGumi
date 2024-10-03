# [백준 - G3️] 14621. 나만 안되는 연애
 
## ⏰  **time**
25분

## :pushpin: **Algorithm**
최소신장트리

## :round_pushpin: **Logic**
- 단순하게 크루스칼 알고리즘을 사용해서 풀면 되는 문제
- 이때, 남초 대학교와 여초 대학교를 연결하는 도로로만 이루어져야 하는 조건을 고려해야 함
  - 따라서 간선의 정보를 우선순위 큐에 넣기 전, 두 대학교가 다른지(남초/여초) 확인해서 다를 때만 큐에 넣어야 함
```java
for (int i = 0; i < M; i++) {
  st = new StringTokenizer(br.readLine());
  int u = Integer.parseInt(st.nextToken());
  int v = Integer.parseInt(st.nextToken());
  int d = Integer.parseInt(st.nextToken());
  if (univ[u] != univ[v]) { // 남초 대학교와 여초 대학교를 잇는 간선만 넣기
    pq.offer(new Edge(u, v, d));
  }
}
```

## :black_nib: **Review**
간선의 정보가 주어지길래 크루스칼 알고리즘을 사용했다. 또 유니온 파인드를 할 때 부모 노드로 합쳐주는 과정을 빼먹을 뻔 했다.. 조심하자

## 📡**Link**
- https://www.acmicpc.net/problem/14621
