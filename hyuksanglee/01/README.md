# [PGS - Lv2] 01_무인도 여행

## ⏰**time**

- 30분

## :pushpin: **Algorithm**

- bfs

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**

1. 가장 먼저 육지인 부분을 찾고 그 찾은 땅에서  bfs 탐색으로 내부 숫자를 더해줌
   ```
    public int find(int x, int y, String[] maps){
        Queue<int[]>que = new ArrayDeque<>();
        que.add(new int[]{x,y});
        int total = maps[x].charAt(y) - '0';
        while(!que.isEmpty()){
            int[] data = que.poll();
            int cx = data[0];
            int cy = data[1];
            for(int d = 0; d<4; d++){
                int nx = dx[d]+ cx;
                int ny = dy[d]+cy;
                if(nx<0 || ny<0 || nx>=maps.length || ny>=maps[0].length())       {
                    continue;
                }
                if(maps[nx].charAt(ny) != 'X' && !check[nx][ny]){
                    check[nx][ny]=true;
                    total+= maps[nx].charAt(ny) - '0';
                    que.add(new int[]{nx,ny});
                }
            }
        }
        
        return total;
    }
   ```
2. 탐색하고 결과가 나오면 배열에 넣어주고 마지막에 넣은 값이 있으면 정렬해서 출력 
3. 없으면 -1 넣어서 출력
## :black_nib: **Review**

- 완탐은 쉽지

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/154540?language=java
