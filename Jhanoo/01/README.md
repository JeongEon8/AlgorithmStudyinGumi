# [백준 - 골드 3] 16236. 아기 상어

## ⏰**time**

104분

## :pushpin: **Algorithm**

- BFS (최단 거리 탐색)
- 시뮬레이션

## ⏲️**Time Complexity**

한 번 먹이를 찾을 때마다 BFS: $O(N^2)$  
먹는 횟수를 최대 $O(N^2)$라 보면 전체는 대략 $O(N^3)$ 수준.

## :round_pushpin: **Logic**

1. 입력을 받아 아기 상어의 시작 위치를 찾고, 그 자리는 0으로 비워 둡니다.

```java
N = Integer.parseInt(br.readLine());
map = new int[N][N];
int sx = -1, sy = -1;
for (int y = 0; y < N; y++) {
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int x = 0; x < N; x++) {
        map[y][x] = Integer.parseInt(st.nextToken());
        if (map[y][x] == 9) {
            sy = y; sx = x;
            map[y][x] = 0;
        }
    }
}
```

2. 상어의 크기(`size`), 현재까지 먹은 물고기 수(`eat`), 총 시간(`time`)을 관리하면서,  
   더 이상 먹을 수 있는 물고기가 없을 때까지 “가장 가까운 먹이”를 반복해서 찾습니다.

```java
int size = 2, eat = 0, time = 0;
while (true) {
    Prey prey = findNextPrey(sx, sy, size);
    if (prey == null) break;

    time += prey.dist;
    sx = prey.x; sy = prey.y;
    map[sy][sx] = 0;
    if (++eat == size) { eat = 0; size++; }
}
System.out.println(time);
```

3. `findNextPrey`에서는 BFS로 상어의 현재 위치에서 갈 수 있는 칸을 탐색하며,
   - 상어 크기보다 작은 물고기만 “먹이 후보”로 보고,
   - 최소 거리보다 더 먼 칸은 탐색을 중단하며,
   - 거리가 같다면 **위쪽(y가 작을수록) → 왼쪽(x가 작을수록)** 우선으로 먹이를 고릅니다.

```java
static Prey findNextPrey(int sx, int sy, int size) {
    boolean[][] visited = new boolean[N][N];
    Queue<int[]> q = new ArrayDeque<>();
    q.offer(new int[]{sx, sy, 0});
    visited[sy][sx] = true;

    int bestDist = Integer.MAX_VALUE;
    int bestX = -1, bestY = -1;

    while (!q.isEmpty()) {
        int[] cur = q.poll();
        int x = cur[0], y = cur[1], dist = cur[2];
        if (dist > bestDist) break;

        int cell = map[y][x];
        if (cell > 0 && cell < size) {
            if (dist < bestDist || (y < bestY || (y == bestY && x < bestX))) {
                bestDist = dist;
                bestX = x; bestY = y;
            }
        }

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir], ny = y + dy[dir];
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            if (visited[ny][nx] || map[ny][nx] > size) continue;
            visited[ny][nx] = true;
            q.offer(new int[]{nx, ny, dist + 1});
        }
    }

    if (bestDist == Integer.MAX_VALUE) return null;
    return new Prey(bestX, bestY, bestDist);
}
```

## :black_nib: **Review**

- 처음에는 BFS 탐색 중 물고기를 바로 먹고 남은 먹을 수 있는 물고기 수를 갱신하는 방식으로 구현했는데, 이렇게 하면 다른 위치에서 탐색 중일 때, 이미 갱신되어버린 남은 물고기 수 때문에 오작동하게 된다...
- 따라서 BFS를 수행하여 최단거리로 먹을 수 있는 물고기를 찾은 후 이동하는 방식으로 수정했다.

## 📡 Link

https://www.acmicpc.net/problem/16236
