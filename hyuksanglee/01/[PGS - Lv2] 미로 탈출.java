import java.util.*;
class Solution {
    
    static int N ,M;
    public int solution(String[] maps) {
        int answer = 0;
        N = maps.length;
        M = maps[0].length();
        int x =0;
        int y=0;
        for(int i =0; i<N; i++){
            for(int j = 0; j<M; j++){
                if(maps[i].charAt(j)=='S'){
                    y=i;
                    x=j;
                }
            }
        }
        
        Info info = bfs(x,y,'L',maps);
        
        if(info.count == -1){
            return -1;
        }else{
            answer+= info.count;
            info = bfs(info.x, info.y, 'E', maps);
        }
        
        if(info.count == -1){
            return -1;
        }else{
          answer+= info.count;  
        }
        
        return answer;
    }
    
    class Info{
        int x;
        int y;
        int count;
        Info(int x , int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
    
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
}
