# [백준- G4] 14497. 주난의 난
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
BFS + 우선순위 큐 (or 다익스트라)

## ⏲️**Time Complexity**
$O(NMlog(NM))$

## :round_pushpin: **Logic**
- 최소 점프 횟수로 이동해야 하므로, 점프 횟수를 기준으로 정렬하는 우선순위 큐 사용하기
- 빈 공간이면 계속해서 파동이 퍼질 수 있음
  - `map[nx][ny] = '0'`이면 점프 횟수 증가하지 않고 PQ에 넣기
- 사람이 서있으면 파동이 멈춤
  - 나머지는 점프 횟수 증가하고 PQ에 넣기
```java
static void bfs(int sx, int sy, int ex, int ey) {
  PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.jump, n2.jump));
  pq.offer(new Node(sx, sy, 0));
  visited[sx][sy] = true;
  
  while (!pq.isEmpty()) {
    Node now = pq.poll();
  
    // 초코바를 가진 학생에 도달한 경우
    if (now.x == ex && now.y == ey) {
      System.out.println(now.jump);
      break;
    }
  
    for (int j = 0; j < 4; j++) {
      int nx = now.x + dx[j];
      int ny = now.y + dy[j];
      if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny])
        continue;
  
      // 장애물이 없으면 계속해서 퍼짐 (점프 횟수 그대로)
      // 장애물이 있으면 퍼지는 것이 멈춤 (점프 횟수 + 1)
      int newJump = (map[nx][ny] == '0' ? now.jump : now.jump + 1);
      pq.offer(new Node(nx, ny, newJump));
      visited[nx][ny] = true;
    }
  }
}
```

## :black_nib: **Review**
다익스트라로도 풀 수 있지만 익숙한 PQ + BFS로 풀었다.

## 📡**Link**
- https://www.acmicpc.net/problem/14497
