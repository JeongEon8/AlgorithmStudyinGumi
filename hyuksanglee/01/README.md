# [PGS - Lv2] 01_미로 탈출

## ⏰**time**

30분

## :pushpin: **Algorithm**

-bfs

## ⏲️**Time Complexity**

$O(N*M)$ 

## :round_pushpin: **Logic**

1. bfs로 L을 찾아주고 못찾을 경우 -1 리턴 아닐경우 움직인 개수를 더해주고 해당 좌표에서 E를 찾아준다
2. 여기서도 못찾을 경우 -1 리턴하고 찾을경우 개수를 더해서 리턴해준다
   ```
       public Info bfs(int x, int y, char find, String[] maps){
              Queue<Info> que = new ArrayDeque<>();
              que.add(new Info(x,y,0));
              int[] dx = {1,0,-1,0};
              int[] dy = {0,1,0,-1};
              boolean[][] check = new boolean[N][M];
              while(!que.isEmpty()){
                  Info info = que.poll();
                  if(maps[info.y].charAt(info.x)== find){
                      return info;
                  }
                  for(int d = 0; d<4; d++){
                      int nx = info.x+dx[d];
                      int ny = info.y+dy[d];
                      if(nx<0 || ny<0 || nx>= M || ny>=N){
                          continue;
                      }
                      if(maps[ny].charAt(nx)!='X' && !check[ny][nx]){
                          check[ny][nx]=true;
                          que.add(new Info(nx, ny, info.count+1));
                      }
                      
                  }
              }
              return new Info(-1,-1,-1);
          }
   ```

## :black_nib: **Review**

- 카카오 문제 풀다가 1시간 고민해서 답지를 봤는데도 몰라서 이 문제로 넘어 왔는데 이문제는 풀어보니 너무 편안

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/159993
