# [백준 - G5] 16928. 뱀과 사다리 게임
 
## ⏰  **time**
40분

## :pushpin: **Algorithm**
BFS

## :round_pushpin: **Logic**
- 100번 칸까지 도착하기 위해 던지는 주사위의 횟수가 최소가 되야 함
  - BFS를 사용하면 되는 문제
- 1번부터 시작하기
  - 주사위에 적힌 수가 1~6이므로 반복문을 통해 1칸, 2칸, … 6칸 이동하는 경우를 살펴보기
  - 만약 이동한 위치가 사다리 or 뱀과 연결되었다면 해당 위치를 큐에 넣기
```java
static void bfs(int x) {
  // [0]: 좌표, [1]: 거리
  PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> Integer.compare(p1[1], p2[1]));
  pq.offer(new int[] { x, 0 });
  visited[x] = true;

  while (!pq.isEmpty()) {
    int[] now = pq.poll();
    if (now[0] == MAX) {
      System.out.println(now[1]);
      break;
    }

    // 주사위 수: 1 ~ 6
    for (int i = 1; i <= 6; i++) {
      int next = now[0] + i;
      if (next <= MAX && !visited[next]) {
        visited[next] = true;
        if (ladder.containsKey(next)) {
          int newNext = ladder.get(next);
          pq.offer(new int[] { newNext, now[1] + 1 });
          visited[newNext] = true;
        } else if (snake.containsKey(next)) {
          int newNext = snake.get(next);
          pq.offer(new int[] { newNext, now[1] + 1 });
          visited[newNext] = true;
        } else {
          pq.offer(new int[] { next, now[1] + 1 });
        }
      }
    }
  }
}
```

## :black_nib: **Review**
사다리의 수와 뱀의 수가 따로 주어져서 방문 처리하는 것에 함정이 있나 싶었지만 그냥 BFS로 풀면 되는 문제였다..

## 📡**Link**
- https://www.acmicpc.net/problem/16928
