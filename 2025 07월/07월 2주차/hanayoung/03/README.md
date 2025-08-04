# [백준 - G3] 4179.불!

## ⏰  **time**
4시간

## :pushpin: **Algorithm**
BFS

## ⏲️**Time Complexity**
$O(R*C)$

## :round_pushpin: **Logic**
1. 불이 번진 초를 fireVisited에 저장하기 위해 불로만 BFS, '.'이고 방문한 적 없을 때만 값 업데이트 및 큐에 추가
```java
        while (queue.size() > 0) {
            Point cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                    continue;
                }

                if (maps[nx][ny] == '.' && fireVisited[nx][ny] == 0) {
                    queue.add(new Point(nx, ny));
                    fireVisited[nx][ny] = fireVisited[cur.x][cur.y] + 1;
                }
            }
        }
```
2. 메모리 낭비 막기 위해 동일한 큐 사용, 가장자리에 도달할 경우 종료. '.'이고 방문한 적 없으며, 지훈이가 이동할 당시 불이 번지지 않은 곳일 경우 이동
```java
        while (queue.size() > 0) {
            Point cur = queue.poll();
            if (cur.x == 0 || cur.y == 0 || cur.x == R - 1 || cur.y == C - 1) {
                answer = visited[cur.x][cur.y];
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                    continue;
                }

                if (maps[nx][ny] == '.' && (visited[nx][ny] == 0 || visited[nx][ny] > visited[cur.x][cur.y] + 1) && (fireVisited[nx][ny] > visited[cur.x][cur.y] + 1 || fireVisited[nx][ny] == 0)) {
                    queue.add(new Point(nx, ny));
                    visited[nx][ny] = visited[cur.x][cur.y] + 1;
                }
            }
        }
```

## :black_nib: **Review**
- 큐를 두 개 쓸 생각을 못해서 너무 오래걸렸던 문제... 거기다가 메모리 초과까지,,

## 📡 Link
https://www.acmicpc.net/problem/4179
