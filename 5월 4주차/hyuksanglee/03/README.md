# [PGS - Lv2] 03_게임 맵 최단거리

## ⏰**time**

- 20분

## :pushpin: **Algorithm**

- bfs

## ⏲️**Time Complexity**

$O(N^2)$ 

## :round_pushpin: **Logic**

1. bfs를 이용하여 1이고 방문하지 않은곳을 탐색하여 목적지까지 가장 빨리 도착하는 값 출력
   ```java
    while(!que.isEmpty()){
            Info data = que.poll();
            int cx = data.x;
            int cy = data.y;
            if(cx==N-1 && cy == M-1){
                return data.count;
            }
            for(int d = 0; d<4; d++){
                int nx = cx + dx[d];
                int ny = cy + dy[d];
                if(nx<0 || ny <0 || nx>=N || ny>=M){
                    continue;
                }
                
                if( maps[nx][ny] ==1){
                   maps[nx][ny]=2;
                    que.add(new Info(nx, ny, data.count+1));
                }
                
                
            }
        }
   ```

## :black_nib: **Review**

- bfs는 껌이지

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/1844
