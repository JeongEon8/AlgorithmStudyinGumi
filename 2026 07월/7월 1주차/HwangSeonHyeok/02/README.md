# [PGS - LV2] 169199. 리코쳇 로봇

## ⏰ **time**

20분

## :pushpin: **Algorithm**
- BFS

## ⏲️**Time Complexity**

$O(n)$

## :round_pushpin: **Logic**
1이동으로 벽이나 장애물까지 이동하는 bfs를 한다. 방문점은 그 멈춘 점을 기준으로 해야한다.
```java
Queue<Point> q = new ArrayDeque<>();
boolean[][] visited = new boolean[r][c];
q.add(new Point(startY,startX,0));
visited[startY][startX] = true;
while(!q.isEmpty()){
    Point p = q.poll();
    if(board[p.y].charAt(p.x)=='G'){
        return p.step;
    }
    for(int i = 0; i<4; i++){
        int currentX = p.x;
        int currentY = p.y;
        while(true){
            int nextX = currentX + dx[i];
            int nextY = currentY + dy[i];
            if(nextY<0 || nextY>=r||nextX<0 || nextX>=c|| board[nextY].charAt(nextX)=='D'){
                break;
                
            }
            currentX = nextX;
            currentY = nextY;
        }
        if(!visited[currentY][currentX]){
            visited[currentY][currentX] = true;
            q.add(new Point(currentY,currentX, p.step+1));
        }
        
    }
    
}
```

## :black_nib: **Review**

## 📡**Link**
https://school.programmers.co.kr/learn/courses/30/lessons/169199