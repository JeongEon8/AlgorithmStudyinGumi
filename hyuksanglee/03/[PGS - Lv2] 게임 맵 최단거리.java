import java.util.*;

class Info{
    int x;
    int y;
    int count;
    Info(int x, int y, int count){
        this.x = x;
        this.y = y;
        this.count = count;
    }
}
class Solution {
    public int solution(int[][] maps) {
        int answer = -1;
        int N = maps.length;
        int M = maps[0].length;
        
        Queue<Info> que = new ArrayDeque<>();
        que.add(new Info(0,0,1));
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        maps[0][0] =2;
        
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
        
        
        return answer;
    }
}
