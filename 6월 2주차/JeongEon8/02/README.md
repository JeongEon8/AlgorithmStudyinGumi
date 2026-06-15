# [PGS - Lv2] 02_게임 맵 최단거리

## ⏰**time**
30분

## :pushpin: **Algorithm**
BFS

## ⏲️**Time Complexity**
$O(N*N)$

## :round_pushpin: **Logic**
1. visited[새로운 y좌표][새로운 x좌표]  = visited[원래 y좌표][원래 x좌표] + 1 을 진행
2. 가장 먼저 ny == n - 1 && nx == m - 1이 되는 경우에 visited[ny][nx]를 return
   ```cpp
    while(!q.empty()){
        int y = q.front().first;
        int x = q.front().second;
        q.pop();
        
        for(int i = 0; i < 4; i++){
            int ny = y+ dy[i];
            int nx = x + dx[i];
            
            if(0 <= ny && ny < n && 0 <= nx && nx < m){
                if(maps[ny][nx] == 1&& visited[ny][nx] == 0){
                    q.push(make_pair(ny,nx));
                    visited[ny][nx]= visited[y][x] + 1;
                    if(ny == n - 1 && nx == m - 1)
                        return visited[ny][nx];
                }
            }
        }
    }
   ```

## :black_nib: **Review**
- 

## 📡 Link
[프로그래머스 LV2 게임 맵 최단거리](https://school.programmers.co.kr/learn/courses/30/lessons/1844)
