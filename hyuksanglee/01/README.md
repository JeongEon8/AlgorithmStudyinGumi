# [백준- G4] 17141. 연구소 2
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
BFS

## ⏲️**Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**
- 바이러스를 놓을 수 있는 위치 저장 후, 조합으로 바이러스 두는 위치 정하기
- 바이러스 두는 위치를 다 정하면 BFS 탐색으로 바이러스가 전부 다 퍼지는 최소 시간 구하기
```java
// 바이러스를 놓을 위치 정하기
static void setVirusPlace(int depth, int start) {
    // 위치 M개 다 선택한 경우
    if (depth == M) {
        // 모든 빈 칸에 바이러스를 퍼뜨리는 최소 시간 구하기
        minTime = Math.min(minTime, getMinTime());
        return;
    }

    for (int i = start; i < emptyList.size(); i++) {
        int[] now = emptyList.get(i);
        virusPlace[depth][0] = now[0];
        virusPlace[depth][1] = now[1];
        setVirusPlace(depth + 1, i + 1);
    }
}

// 바이러스가 퍼지는 최소 시간 구하기
static int getMinTime() {
    Queue<int[]> queue = new ArrayDeque<>();
    dist = new int[N][N];
    for (int[] place : virusPlace) {
        int x = place[0], y = place[1];
        queue.offer(new int[]{x, y});
        dist[x][y] = 1;
    }

    int spread = 0;
    while (!queue.isEmpty()) {
        int[] now = queue.poll();
        int x = now[0], y = now[1];
        if (++spread == spreadCount) {
            return dist[x][y] - 1;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                continue;
            }

            if (dist[nx][ny] != 0 || map[nx][ny] == 1) {
                continue;
            }

            // 빈 칸이나 바이러스가 퍼질 수 있는 칸으로 이동 가능
            queue.offer(new int[]{nx, ny});
            dist[nx][ny] = dist[x][y] + 1;
        }
    }
    return INF;
}
```

## :black_nib: **Review**
다른 연구소 문제랑 비슷했다!

## 📡**Link**
- https://www.acmicpc.net/problem/17141
