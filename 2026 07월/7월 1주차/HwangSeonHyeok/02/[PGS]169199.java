import java.util.*;
class Solution {
    class Point{
        int y,x,step;
        Point(int y, int x, int step){
            this.y = y;
            this.x = x;
            this.step = step;
        }
    }
    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};
    public int solution(String[] board) {
        int r = board.length;
        int c = board[0].length();
        int startY = 0;
        int startX = 0;
        for(int i = 0; i<r; i++){
            for(int j = 0; j<c; j++){
                if(board[i].charAt(j)=='R'){
                    startY = i;
                    startX = j;
                }
            }
        }
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
        return -1;
    }
}