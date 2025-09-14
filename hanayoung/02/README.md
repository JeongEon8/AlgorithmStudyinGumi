# [백준 - G4] 2573. 빙산

## ⏰  **time**
70분

## :pushpin: **Algorithm**
BFS

## ⏲️**Time Complexity**
$O(Y*N*M)$

## :round_pushpin: **Logic**
1. 빙산의 개수가 다 녹을 때까지 while문 반복하되, 덩어리가 1개 초과가 될 경우 탈출
```java
 while (icebergs.size() > 0) {
  ...
  if(chunk > 1) break;
 }
```
2. 모든 빙산들을 탐색, 방문한 적 없는 빙산들만 queue에 추가하고 그와 연결되는 빙산들 확인, 만약 분리되어있다면 chunk가 1 초과로 나타남
```java
            for (Point p : icebergs) {
                if (visited[p.x][p.y] == false) {
                    chunk++;
                    q.add(p);
                    visited[p.x][p.y] = true;
                    while (q.size() > 0) {
                        Point cur = q.poll();
                        for (int i = 0; i < 4; i++) {
                            int nx = cur.x + dx[i];
                            int ny = cur.y + dy[i];

                            if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                                continue;
                            }

                            if(visited[nx][ny] == false && maps[nx][ny] > 0) {
                                q.add(new Point(nx, ny));
                                visited[nx][ny] = true;
                            }
                        }
                    }
                }
            }
```
3. minus 배열은 바다와 맞닿아 낮아진 높이, gone은 사라진 빙산들 좌표 리스트, count는 바다와 맞닿은 면 개수
4. 빙산들을 상하좌우를 탐색하며 바다인 경우(maps[nx][ny] == 0) count 증가
5. 다 녹았다면 gone에 추가하고, minus 배열 업데이트, 아니라면 줄어든 높이 반영
```java
            int[][] minus = new int[N][M];
            ArrayList<Point> gone = new ArrayList<>();
            for (Point p : icebergs) {
                int count = 0;
                for (int i = 0; i < 4; i++) {
                    int nx = p.x + dx[i];
                    int ny = p.y + dy[i];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                        continue;
                    }

                    if (maps[nx][ny] == 0) {
                        count++;
                    }
                }
                if(maps[p.x][p.y] - count <= 0) {
                    gone.add(p);
                    minus[p.x][p.y] = 0;
                } else {
                    minus[p.x][p.y] = maps[p.x][p.y] - count;
                }
            }
```
5. maps에 값 깊은 복사, 빙산리스트에 사라진 빙산들 제거하고, 연수를 의미하는 answer는 1 증가
```java
            for (int i = 0; i < N; i++) {
                maps[i] = minus[i].clone();
            }
            icebergs.removeAll(gone);
            answer++;
```
6. 마지막에 빙산리스트의 사이즈가 0이면 다 녹았던 것이므로, answer는 0으로 업데이트
```java
 if(icebergs.size() == 0) answer = 0;
```

## :black_nib: **Review**
- bfs 문제인걸 알고 봤음에도 어떻게 써먹어야하지..? 하고 왕왕 헤맸던 문제 bfs 다시 친해지자...

## 📡**Link**
- https://www.acmicpc.net/problem/2573
