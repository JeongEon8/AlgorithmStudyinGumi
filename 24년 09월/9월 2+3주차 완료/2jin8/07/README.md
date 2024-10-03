# [백준 - G3️] 16236. 아기 상어
 
## ⏰  **time**
2시간

## :pushpin: **Algorithm**
BFS + 우선순위 큐

## :round_pushpin: **Logic**
- BFS 탐색을 통해 물고기와의 최단 거리를 구하면 됨
- 조건이 3개 주어지므로 그냥 큐를 사용하면 안됨
- 우선순위 큐를 이용해서 `거리 순 > x좌표 순 > y좌표 순`으로 정렬한 뒤, 해당 조건에 가장 적합하는 칸 정보 꺼내기
  - 해당 칸에 물고기가 있고 잡아먹을 수 있는 물고기라면 잡아먹기
```java
int sharkSize = 2; // 아기 상어의 초기 크기는 2
int time = 0, eatCnt = 0;
PriorityQueue<Fish> pq = new PriorityQueue<>((f1, f2) -> {
  if (f1.dist == f2.dist) { // 거리가 같은 경우
    if (f1.x == f2.x) { // x좌표가 같은 경우
      return f1.y - f2.y; // 3. y좌표 기준 오름차순 정렬
    }
    return f1.x - f2.x; // 2. x좌표 기준 오름차순 정렬
  }
  return f1.dist - f2.dist; // 1. 거리 기준 오름차순 정렬
});
while (true) {
  boolean eatFish = false;
  boolean[][] visited = new boolean[N][N];
  pq.clear();

  pq.offer(new Fish(sharkX, sharkY, 0));
  visited[sharkX][sharkY] = true;

  while (!pq.isEmpty()) {
    Fish fish = pq.poll();
    int x = fish.x, y = fish.y;
    // 먹을 수 있는 물고기인지 확인하기
    if (arr[x][y] != 0 && arr[x][y] < sharkSize) {
      time += fish.dist; // 물고기를 잡아먹을 수 있는 시간 계산
      arr[x][y] = 0; // 물고기 없어진 것 표시
      eatCnt++; // 먹은 물고기의 수 증가
      eatFish = true; // 물고기 먹었다고 표시
      sharkX = x; // 상어 위치 이동
      sharkY = y;
      break;
    }

    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];
      if (nx < 0 || ny < 0 || nx >= N || ny >= N)
        continue;

      // 이미 방문했거나 물고기 크기가 상어 크기보다 크다면 이동 불가
      if (visited[nx][ny] || arr[nx][ny] > sharkSize)
        continue;

      pq.offer(new Fish(nx, ny, fish.dist + 1));
      visited[nx][ny] = true;
    }
  }

  // 더 이상 먹을 물고기가 없으면 엄마 상어에게 도움 요청
  if (!eatFish) { // 물고기를 먹지 못한 경우
    break;
  }

  // 자신의 크기만큼 물고기를 먹으면 크기 1 증가
  if (eatCnt == sharkSize) {
    sharkSize++;
    eatCnt = 0;
  }
}
```

## :black_nib: **Review**
처음에 완전 복잡한 방법으로 풀었었다. 답은 맞았지만 시간이 많이 걸려 다른 풀이를 참고해서 다시 풀었다... 제발 문제를 쓸데없이 복잡하게 풀지말자..

## 📡**Link**
- https://www.acmicpc.net/problem/16236
