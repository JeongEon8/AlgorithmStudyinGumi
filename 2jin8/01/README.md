# [백준- G1] 9328. 열쇠
 
## ⏰  **time**
2시간

## :pushpin: **Algorithm**
BFS + 비트마스킹

## ⏲️**Time Complexity**
$O(h * w)$

## :round_pushpin: **Logic**
- 가장자리 중 한 곳에서 시작할 수 있으므로 배열의 크기를 2씩 증가하여 `(0, 0)`에서 탐색을 시작하기
- 방문 배열에는 방문했을 때의 획득한 열쇠 정보를 저장하기
  - 3차원 방문 배열은 오버플로우 발생함
  - 획득한 열쇠가 0개일 수도 있으므로, -1로 초기화를 해야 함
```java
static int bfs(Point start) {
  Queue<Point> queue = new ArrayDeque<>();
  queue.offer(start);
  visited[start.x][start.y] = KEY;

  int docs = 0;
  while (!queue.isEmpty()) {
    Point now = queue.poll();
    System.out.println("(" + now.x + ", " + now.y + ")");

    for (int i = 0; i < 4; i++) {
      int nx = now.x + dx[i];
      int ny = now.y + dy[i];
      if (nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length)
        continue;

      // 벽이거나 이미 동일한 열쇠 정보로 방문한 경우
      if (map[nx][ny] == '*' || visited[nx][ny] == KEY)
        continue;

      char status = map[nx][ny];
      if (status >= 'A' && status <= 'Z') { // 문
        int door = status - 'A';
        if ((KEY & (1 << door)) == 0) { // 문을 열 수 있는 열쇠가 없는 경우라면 그냥 넘어가기
          continue;
        }
      } else if (status >= 'a' && status <= 'z') { // 열쇠
        int key = status - 'a';
        KEY |= (1 << key);
      } else if (status == '$') { // 문서
        docs++;
      }

      queue.offer(new Point(nx, ny));
      visited[nx][ny] = KEY;
      map[nx][ny] = '.'; // 이미 방문한 곳은 열쇠를 획득했고 문도 열 수 있고 문서도 획득했으므로 빈 칸으로 변경하기
    }
  }
  return docs;
}
```

## :black_nib: **Review**
달이 차오르다 문제와 유사하지만, 가질 수 있는 열쇠가 26개이므로 3차원 방문 배열을 만들면 메모리가 터진다.
그리고 최단 경로를 구하는 것이 아니라 이동 여부를 확인하는 것이므로 전역변수를 이용해서 가질 수 있는 열쇠의 정보를 저장하면 된다. ( 이게 이해가 안되서 계속 고민했다..)

## 📡**Link**
- https://www.acmicpc.net/problem/9328
