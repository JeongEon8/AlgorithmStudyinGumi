# [백준 - S2] 1012. 유기농 배추

## ⏰  **time**
20분

## :pushpin: **Algorithm**
bfs

## ⏲️**Time Complexity**
$O(T*M*N)$

## :round_pushpin: **Logic**
1. 변수 생성, maps는 배추 존재 지도를, visited는 방문여부를 담을 배열,list는 배추가 존재하는 위치를 담는 리스트 
```java
int[][] maps = new int[N][M];
boolean[][] visited = new boolean[N][M];
List<Point> list = new ArrayList<>();
```
2. list를 탐색하며 배추가 존재하는 지점만 우선적으로 탐색
3. 방문한적 없는 위치이면 q에 해당 좌표를 삽입, 방문처리, answer 증가 후 while문 돌기
4. 사방향 탐색하며 이동할 수 있고 방문한 적 없으며 배추가 존재하면 q에 다음 좌표 삽입 및 방문처리
```java
            for(Point p: list) {
                if(visited[p.x][p.y] == false) {
                    q.add(p);
                    visited[p.x][p.y] = true;
                    answer++;
                    while(q.size() > 0) {
                        Point cur = q.poll();
                        for(int i = 0; i < 4; i++) {
                            int nx = cur.x + dx[i];
                            int ny = cur.y + dy[i];

                            if(nx < 0 || nx >= N|| ny < 0 || ny >= M) continue;

                            if(visited[nx][ny] == false && maps[nx][ny] == 1) {
                                q.add(new Point(nx, ny));
                                visited[nx][ny] = true;
                            }
                        }
                    }
                }
            }
```

## :black_nib: **Review**
- 평소에 풀던 실버 단계보다 높아서 뭔가 다른 게 있나?... 싶었지만 아니었다!

## 📡 Link
https://www.acmicpc.net/problem/1012
