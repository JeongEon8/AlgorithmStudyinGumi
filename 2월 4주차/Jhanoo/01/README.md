# [백준 - 골드 4] 2206. 벽 부수고 이동하기

## ⏰**time**

37분

## :pushpin: **Algorithm**

- BFS (최단 거리 탐색)
- 상태 확장 (벽 부수기 여부)

## ⏲️**Time Complexity**

$O(N \\times M)$  
각 칸을 “벽을 안 부순 상태 / 하나 부순 상태” 두 번만 방문하므로 상수배를 곱한 정도.

## :round_pushpin: **Logic**

1. 맵을 입력받아 `wall[x][y]`에 벽 여부를 저장하고, 방문 배열을  
   `visited[x][y][break]` (break = 0: 아직 안 부숨, 1: 이미 한 번 부숨)으로 둡니다.

```java
wall = new boolean[N][M];
visited = new boolean[N][M][2];
for (int i = 0; i < N; i++) {
    String s = br.readLine();
    for (int j = 0; j < M; j++) {
        wall[i][j] = (s.charAt(j) == '1');
    }
}
```

2. BFS 큐에는 `(x, y, destroyCnt, dist)`를 넣고, 시작점 `(0,0,0,1)`에서 시작합니다.

```java
Queue<int[]> q = new ArrayDeque<>();
q.offer(new int[]{0, 0, 0, 1}); // x, y, destroyCnt, dist
visited[0][0][0] = true;
```

3. 네 방향으로 이동을 시도하면서,
   - 벽을 만났을 때 아직 한 번도 부순 적이 없고(`destroyCnt == 0`),  
     해당 칸을 “벽을 한 번 부순 상태(1)”로 방문한 적이 없다면 그 벽을 부수고 이동합니다.
   - 길인 경우에는 현재 `destroyCnt` 상태를 유지한 채로 이동합니다.

```java
for (int d = 0; d < 4; d++) {
    int nx = x + dx[d];
    int ny = y + dy[d];
    if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

    if (wall[nx][ny]) { // 벽
        if (destroyCnt == 0 && !visited[nx][ny][1]) {
            q.offer(new int[]{nx, ny, 1, dist + 1});
            visited[nx][ny][1] = true;
        }
    } else { // 길
        if (!visited[nx][ny][destroyCnt]) {
            q.offer(new int[]{nx, ny, destroyCnt, dist + 1});
            visited[nx][ny][destroyCnt] = true;
        }
    }
}
```

4. BFS 도중에 목표 지점 `(N-1, M-1)`에 도착하면 그때의 `dist`가 최단 거리이므로 바로 출력하고 종료합니다.  
   큐가 빌 때까지 도달하지 못하면 `-1`을 출력합니다.

```java
if (x == N - 1 && y == M - 1) {
    System.out.println(dist);
    return;
}
// ...
System.out.println(-1);
```

## :black_nib: **Review**

- visited를 벽을 부수기 전과 후로 구분을 지어야 풀린다.

## 📡 Link

https://www.acmicpc.net/problem/2206
