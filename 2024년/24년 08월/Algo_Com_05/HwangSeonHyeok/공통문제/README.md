# [백준 - G4] 14502. 연구소

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 구현
- 그래프 이론
- 브루트포스 알고리즘
  = 그래프 탐색
- 너비 우선 탐색

## :round_pushpin: **Logic**

3곳을 정해 벽을 세우고 바이러스를 퍼트려 안전지역이 현제 기록한 답보다 많으면 기록한다.

```java
   static void solve(int depth, int currentY, int currentX) {
        if (depth == 3) {
            Queue<Point> q = new ArrayDeque<>();
            visited = new boolean[n][m];
            int virusArea = 0;
            for (Point virus : vList) {
                q.add(virus);
                visited[virus.y][virus.x] = true;
                virusArea++;
            }
            while (!q.isEmpty()) {
                Point current = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nextX = current.x + dx[i];
                    int nextY = current.y + dy[i];
                    if (nextY < 0 || nextX < 0 || nextY >= n || nextX >= m || lab[nextY][nextX] == 1
                            || visited[nextY][nextX])
                        continue;
                    visited[nextY][nextX] = true;
                    q.add(new Point(nextY, nextX));
                    virusArea++;
                }
                if (safeArea - virusArea < ans) {
                    return;
                }
            }
            ans = safeArea - virusArea;
            return;
        }

        for (int i = currentY; i < n; i++) {
            for (int j = (i == currentY) ? currentX : 0; j < m; j++) {
                if (lab[i][j] == 0) {
                    lab[i][j] = 1;
                    if (j == m - 1) {
                        solve(depth + 1, currentY + 1, 0);
                    } else {
                        solve(depth + 1, currentY, currentX + 1);
                    }
                    lab[i][j] = 0;
                }
            }
        }

    }

```

## :black_nib: **Review**

벽이 3개라 조합으로 모든 경우의 수를 탐색했다.

## 📡**Link**

https://www.acmicpc.net/problem/14502
