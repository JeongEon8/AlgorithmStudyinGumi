import java.util.*;

class Point{
    int y, x, step;
    Point(int y, int x, int step){
        this.y = y;
        this.x = x;
        this.step = step;
    }
}

class Solution {
    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};
    
    int bfs(String[] maps, Point start, char end){
        int n = maps.length;
        int m = maps[0].length();
        boolean[][] visited = new boolean[n][m];
        Queue<Point> q = new ArrayDeque<>();
        q.add(start);
        visited[start.y][start.x] = true;
        while(!q.isEmpty()){
            Point current = q.poll();
            if(maps[current.y].charAt(current.x)==end){
                return current.step;
            }
            
            for(int i = 0; i<4; i++){
                int nx = current.x+ dx[i];
                int ny = current.y + dy[i];
                if(nx >=0 && ny>=0 && ny<n && nx < m){
                    if(!visited[ny][nx] && maps[ny].charAt(nx) !='X'){
                        visited[ny][nx] = true;
                        q.add(new Point(ny,nx,current.step+1));
                    }
                }
            }
        }
        
        return -1;
    }
    public int solution(String[] maps) {
        int answer = 0;
        Point startPoint = new Point(0,0,0);
        Point leverPoint = new Point(0,0,0);
        for(int i = 0; i<maps.length; i++){
            for(int j = 0; j<maps[i].length();j++){
                char c = maps[i].charAt(j);
                if(c == 'S'){
                    startPoint  = new Point(i,j,0);
                }else if(c=='L'){
                    leverPoint = new Point(i,j,0);
                }
            }
        }
        int toLever = bfs(maps,startPoint,'L');
        if(toLever==-1)return -1;
        int toExit = bfs(maps,leverPoint,'E');
        if(toExit==-1) return -1;
        
        
        return toLever+toExit;
    }
}