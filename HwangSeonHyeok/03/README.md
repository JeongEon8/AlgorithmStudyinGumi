# [백준 - S1] 13903. 출근

## ⏰ **time**

25분

## :pushpin: **Algorithm**
- 그래프 이론
- 그래프 탐색
- 너비 우선 탐색
- 격자 그래프
## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**
이동규칙을 입력 받아서 dx, dy에 직접 저장하고 bfs로 탐색하면된다.
```java
static boolean isInRange(int y, int x) {
    return x >= 0 && y >= 0 && y < r && x < c;
}

static int solve() {
    boolean[][] visited = new boolean[r][c];
    Queue<Point> que = new ArrayDeque<>();
    for (int i = 0; i < c; i++) {
        if (graph[0][i] == 1) {
            que.add(new Point(0, i, 0));
            visited[0][i] = true;
        }
    }
    while (!que.isEmpty()) {
        Point current = que.poll();
        if (current.y == r - 1) {
            return current.step;

        }
        for (int i = 0; i < n; i++) {
            int nextY = current.y + dy[i];
            int nextX = current.x + dx[i];
            if (isInRange(nextY, nextX) && !visited[nextY][nextX] && graph[nextY][nextX] == 1) {
                que.add(new Point(nextY, nextX, current.step + 1));
                visited[nextY][nextX] = true;
            }

        }
    }

    return -1;
}



for (int i = 0; i < n; i++) {
    st = new StringTokenizer(in.readLine());
    dy[i] = Integer.parseInt(st.nextToken());
    dx[i] = Integer.parseInt(st.nextToken());
}
System.out.println(solve());
```

## :black_nib: **Review**
오랜만에 bfs
## 📡**Link**

https://www.acmicpc.net/problem/13903