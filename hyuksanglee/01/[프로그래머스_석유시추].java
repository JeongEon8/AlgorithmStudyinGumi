package programmers;

import java.util.ArrayDeque;
import java.util.Queue;

public class Programmers_석유시추 {

	 static int[] dc = {0, 1, 0, -1};
	    static int[] dr = {1, 0, -1, 0};
	    
	    static class Info{
	        int r;
	        int c;
	        Info(int c, int r){
	            this.r = r;
	            this.c = c;
	        }
	    }
	    
	    public int solution(int[][] land) {
	        int answer = 0;
	        
	        int C = land.length;
	        int R = land[0].length;
	        boolean[][] check = new boolean[C][R];
	        int[] find = new int[R];
	        int[] save = new int[R];
	        int type = 0;
	        int max =0;
	        int id = 0;
	        
	        for(int c = 0; c<C; c++){
	            for(int r = 0; r<R; r++){
	                if(land[c][r] ==1 && check[c][r] == false){
	                    check[c][r] = true;
	                    Queue<Info>que = new ArrayDeque<Info>();
	                    Info info = new Info(c, r);
	                    que.add(info);
	                    
	                    int count =0;
	                    type ++;
	                    
	                    find[r] = type;
	                    
	                    while(!que.isEmpty()){
	                        Info newInfo = que.poll();
	                        count++;
	                        int nc = newInfo.c;
	                        int nr = newInfo.r;
	                        for(int d = 0; d<4; d++){
	                            int cc = nc + dc[d];
	                            int cr = nr + dr[d];
	                            if(cc<0 || cc>=C || cr<0 || cr>=R){
	                                continue;
	                            }
	                            
	                            if(land[cc][cr] == 1 && check[cc][cr] ==false){
	                                check[cc][cr] = true;
	                                info = new Info(cc,cr);
	                                que.add(info);
	                                find[cr] = type;
	                            }
	                        }
	                    }
	                    
	                    for(int i =0; i<R; i++){
	                        if(find[i] == type){
	                            save[i] += count;
	                            if(max< save[i]){
	                                max= save[i];
	                            }
	                        }
	                    }
	                }
	            }
	        }
	        
	        return max;
	    }

}
