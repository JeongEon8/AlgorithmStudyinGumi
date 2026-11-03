# [PGS - Lv2] 01_무인도 여행

## ⏰**time**

- 33분

## :pushpin: **Algorithm**

- bfs

## ⏲️**Time Complexity**

$O(N)$ 

## :round_pushpin: **Logic**

1. 하나씩 탐색을 해주는데 X가 아닐경우 bfs로 탐색하고 숫자인 값만 더해서 리스트에 저장.
   ```
   public int bfs(int r, int c){
           Queue<Info> que = new ArrayDeque<>();
           que.add(new Info(r,c));
           int total = 0;
           while(!que.isEmpty()){
               Info info = que.poll();
               int nr = info.r;
               int nc = info.c;
               total += maps[nr].charAt(nc)-'0';
               for(int d = 0; d<4; d++){
                   int cr = nr + dr[d];
                   int cc = nc + dc[d];
                   
                   if(cr<0 || cc<0 || cr>= maps.length || cc>= maps[0].length()){
                       continue;
                   }
                   
                   char ch = maps[cr].charAt(cc); 
                   if(!check[cr][cc] && ch!='X'){
                       
                       check[cr][cc] = true;
                       que.add(new Info(cr,cc));
                   }
               }
           }
           return total;
       }
   ```

## :black_nib: **Review**

- 

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/154540?language=java
