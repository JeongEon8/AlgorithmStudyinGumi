# [백준 - S1] 2667. 단지번호붙이기

## ⏰  **time**
30분

## :pushpin: **Algorithm**
bfs

## ⏲️**Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**
1. 집 위치를 담는 list 생성
```java
ArrayList<Point> home = new ArrayList<>();
if(maps[i][j] == 1) home.add(new Point(i,j));
```
2. maps에 해당하는 숫자 넣기, 공백없는 문자열로 인식하므로 변환 과정 필요
```java
maps[i][j] = Integer.parseInt(Character.toString(str.charAt(j)));
```
3. home을 돌며 방문한 적 없는 경우 탐색 시작
4. 큐에 좌표를 삽입, 방문 처리 후 큐 돌기
5. 사방향 탐색하며 집이 있고 방문한 적 없다면 방문처리, 큐에 삽입, cnt 증가
6. 우선순위큐에 cnt(집 개수) 삽입
```java
        for(Point p : home) {
            if(visited[p.x][p.y] == false) {
                int cnt = 1;
                q.add(p);
                visited[p.x][p.y] = true;
                while(q.size() > 0) {
                    Point cur = q.poll();

                    for(int i = 0; i < 4; i++) {
                        int nx = cur.x + dx[i];
                        int ny = cur.y + dy[i];

                        if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                        if(maps[nx][ny] == 1 && visited[nx][ny] == false) {
                            q.add(new Point(nx, ny));
                            visited[nx][ny] = true;
                            cnt++;
                        }
                    }
                }
                pQueue.add(cnt);
            }
         }
```
7. pQueue에서 하나씩 꺼내서 오름차순으로 출력
```java
        while(pQueue.size() > 0) {
            sb.append(pQueue.poll()).append("\n");
        }
```


## :black_nib: **Review**
- bfs로 푸는 간단한 문제 실버 조 아

## 📡**Link**
- https://www.acmicpc.net/problem/2667
