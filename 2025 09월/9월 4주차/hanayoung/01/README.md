# [백준 - S1] 3184. 양

## ⏰  **time**
30분

## :pushpin: **Algorithm**
bfs

## ⏲️**Time Complexity**
$O(R × C)$

## :round_pushpin: **Logic**
1. 모든 좌표를 돌며, 방문한 적 없고 양이나 늑대가 있을 경우 탐색
2. Queue로 울타리없이 이동할 수 있는 좌표들 탐색하며 방문처리
3. 해당 좌표에 양이 있으면 sheep++, 늑대가 있으면 wolf++
4. 마리 수 비교 후 answer[0]와 answer[1]에 각각 양과 늑대수 합산
```java
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(visited[i][j] == false && (maps[i][j] == 'v' || maps[i][j] == 'o')) {
                    int sheep = 0;
                    int wolf = 0;

                    Queue<Point> q = new LinkedList<>();
                    q.add(new Point(i,j));
                    visited[i][j] = true;

                    while(q.size() > 0) {
                        Point cur = q.poll();
                        switch(maps[cur.x][cur.y]) {
                            case 'v': wolf++;
                            break;
                            case 'o': sheep++;
                        }
                        
                        for(int l = 0; l < 4; l++) {
                            int nx = cur.x + dx[l];
                            int ny = cur.y + dy[l];

                            if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;

                            if(visited[nx][ny] == false && maps[nx][ny] != '#') {
                                visited[nx][ny] = true;
                                q.add(new Point(nx, ny));
                            }
                        }
                    }
                    if(sheep <= wolf) sheep = 0;
                    else wolf = 0;

                    answer[0] += sheep;
                    answer[1] += wolf;
                }
            }
        }
```



## :black_nib: **Review**
- bfs로 푸는 간단한 문제 실버 조 아

## 📡**Link**
- https://www.acmicpc.net/problem/3184
