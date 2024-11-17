# [백준- G2] 9370. 미확인 도착지
 
## ⏰  **time**
1시간

## :pushpin: **Algorithm**
다익스트라

## ⏲️**Time Complexity**
$O((V+E)logV)$

## :round_pushpin: **Logic**
- 시작점에서 도착지까지 최단 경로로 갈 때, g - h 도로를 지나가는지 확인하는 문제
  - 따라서 다익스트라를 이용해서 최단경로를 찾은 후, 해당 도로를 지나가는지 확인하면 됨
- 그러나 단순 구현만 하면 반례가 너무 많음
  - 최단거리가 같은 것이 존재할 때, **어떻게 g - h 도로에 어떻게 우선순위**를 줄 것인가?를 생각해야 함
- 따라서 **모든 도로의 길이에 * 2**를 한 뒤, **g - h 도로라면 -1을 해서 우선순위**를 주면 됨!
  - **최단경로가 홀수면 g - h 도로를 지나간 것**!
```java
for (int i = 0; i < m; i++) {
  st = new StringTokenizer(br.readLine());
  int a = Integer.parseInt(st.nextToken());
  int b = Integer.parseInt(st.nextToken());
  // 동일한 최단거리가 있을 때, g - h 사이 간선에 우선순위를 주기
  int d = Integer.parseInt(st.nextToken()) * 2; // 모든 가중치에 * 2
  if ((a == g && b == h) || (a == h && b == g)) {
    // g - h 사이 간선이라면 -1을 해서 우선순위 주기
    d--;
  }
  graph[a].add(new Node(b, d));
  graph[b].add(new Node(a, d));
}

ArrayList<Integer> answer = new ArrayList<>();
for (int i = 0; i < t; i++) {
  Arrays.fill(minDist, INF);
  Arrays.fill(visited, false);

  int end = Integer.parseInt(br.readLine());
  int dist = dijkstra(s, end);
  if (dist == -1) // 목적지까지 이동이 불가능하다면 continue
    continue;

  // 최단거리가 홀수면 g - h 사이 간선을 지나갔다는 뜻
  if (dist % 2 == 1) {
    answer.add(end);
  }
}
```

## :black_nib: **Review**
특정 간선에 우선순위를 어떻게 주고 구분하나 싶었는데 짝수/홀수를 이용해서 구분하는 것을 보고 신기했다.. 

## 📡**Link**
- https://www.acmicpc.net/problem/9370
