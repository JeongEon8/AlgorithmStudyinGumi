package programmers;

import java.util.*;

public class Prgrammers_리코쳇로봇 {

	static class Info{
        int i;
        int j;
        int count;
        Info(int i, int j, int count){
            this.i = i;
            this.j = j;
            this.count = count;
        }
    }
    
    static int[] di= {1,0,-1,0};
    static int[] dj= {0,1,0,-1};
    public int solution(String[] board) {
        char[][] map = new char[board.length][board[0].length()];
        boolean[][][] check = new boolean[board.length][board[0].length()][4];
        int si = 0;
        int sj = 0;
        for(int i = 0; i< board.length; i++){
            for(int j = 0; j<board[0].length(); j++){
                char c = board[i].charAt(j);
                map[i][j] = c;
                if(c=='R'){
                    si = i;
                    sj = j;
                }
            }
        }
        
        
        Queue<Info> que = new ArrayDeque<Info>();
        
        check[si][sj][0] = true;
        check[si][sj][1] = true;
        check[si][sj][2] = true;
        check[si][sj][3] = true;
        
        Info info = new Info(si, sj, 0);
        que.add(info);
        while(!que.isEmpty()){
            info = que.poll();
            int ni = info.i;
            int nj = info.j;
            int ncount = info.count;
            for(int d =0; d<4; d++){
                int ci = ni+di[d];
                int cj = nj+dj[d];
                if(ci<0 || ci>=board.length || cj<0 || cj>=board[0].length()){
                    continue;
                }
                if(check[ci][cj][d]==false){
                    while(true){
                    if(ci<0 || ci>=board.length || cj<0 || cj>=board[0].length()){
                            break;
                        }
                        if(map[ci][cj]=='D'){
                            break;
                        }
                        
                        check[ci][cj][d]=true;
                        ci = ci+di[d];
                        cj = cj+dj[d];
                    }
                    ci = ci-di[d];
                    cj = cj - dj[d];
                    
                    if (ci == ni && cj == nj) continue;
                    check[ci][cj][d] = true;
                    if(map[ci][cj]=='G'){
                        return ncount+1;
                    }
                    Info ninfo= new Info(ci,cj,ncount+1);
                    que.add(ninfo);
                }
            }
            
        }
        
        int answer = -1;
        return answer;
    }

}
