# [백준- G3] 16954. 움직이는 미로
 
## ⏰  **time**
1시간

## :pushpin: **Algorithm**
BFS

## :round_pushpin: **Logic**
- 캐릭터가 이동한 후 벽이 이동함
  - 벽을 이동할 때 아래부터 옮겨야 배열의 값이 날라가지 않음
- 벽이 캐릭터가 있는 칸으로 이동하면 더 이상 이동할 수 없음
  - 8방향 탐색하기 전, 현재 위치에 벽이 있는지 확인하기
  - 벽이 있다면 8방향 탐색하지 않기
- 현재 위치에 서 있을 수 있음
  - 현재 위치에 있는 것이 더욱 유리한 경우이므로, 다음에 8방향 탐색을 진행할 수 있어야 함
  - 따라서 각 초마다 방문 배열을 초기화해야 함
```java
static int bfs() {
  Queue<int[]> queue = new ArrayDeque<>();
  queue.offer(new int[] { N - 1, 0 });
  visited[N - 1][0] = true;

  // 이동 순서: 캐릭터 > 벽
  while (!queue.isEmpty()) {
    // 캐릭터 이동
    int size = queue.size();
    // 시간이 흐를 때마다 초기화하기
    visited = new boolean[N][N]; // 이동하지 않고 현재 위치에 서있는 경우도 있음
    for (int s = 0; s < size; s++) {
      int[] now = queue.poll();
      if (now[0] == 0 && now[1] == N - 1) // 오른쪽 가장 윗 칸에 도착한 경우
        return 1;

      if (map[now[0]][now[1]] == '#') // 벽이 캐릭터가 있는 칸으로 이동한 경우
        continue; // 캐릭터 이동 불가

      // 8방향으로 이동하기
      for (int i = 0; i < 8; i++) {
        int nx = now[0] + dx[i];
        int ny = now[1] + dy[i];
        if (nx < 0 || ny < 0 || nx >= N || ny >= N)
          continue;

        // 벽이 아니고 방문하지 않은 칸인 경우
        if (map[nx][ny] == '.' && !visited[nx][ny]) {
          queue.offer(new int[] { nx, ny });
          visited[nx][ny] = true;
        }
      }
      // 현재 위치에 서있기
      queue.offer(now);	
    }
    // 벽이 한 칸씩 내려감
    for (int i = N - 2; i >= 0; i--) {
      map[i + 1] = map[i].clone();
    }
    Arrays.fill(map[0], '.'); // 제일 윗 칸은 모두 빈 칸
  }
  return 0;
}
```

## :black_nib: **Review**
각 초마다 방문 배열을 초기화해야 했는데 해주지 않아서 틀렸다. 문제에서 주어진 조건들을 그냥 넘어가지 말고 잘 활용하자..

## 📡**Link**
- https://www.acmicpc.net/problem/16954
