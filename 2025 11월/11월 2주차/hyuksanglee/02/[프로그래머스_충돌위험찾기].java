package programmers;

import java.util.*;

public class Programmers_충돌위험찾기 {

	static class Info{
        int r;              
        int c;            
        int[] arrive;      
        Queue<Integer> que; 
        boolean done;       
        
        Info(int r, int c){
            this.r = r;
            this.c = c;
            arrive = new int[2];
            que = new ArrayDeque<Integer>();
            done = false;
        }
    }
    
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        
        Info[] infos = new Info[routes.length];
        
        int maxR = 0; 
        int maxC = 0; 
        
        int count = 0;
        
        for (int i = 0; i < points.length; i++){
            if (maxR < points[i][1]) maxR = points[i][1];
            if (maxC < points[i][0]) maxC = points[i][0];
        }
        
        for (int i = 0; i < routes.length; i++){
            int start = 0;
            int end = 0;
            Queue<Integer> que = new ArrayDeque<Integer>();
            
            for (int j = 0; j < routes[i].length; j++){
                if (j == 0){
                    start = routes[i][j] - 1;     
                } else if (j == 1){
                    end = routes[i][j] - 1;
                    count++;                       
                } else {
                    que.add(routes[i][j] - 1);
                    count++;                      
                }
            }
            
            Info info = new Info(points[start][1], points[start][0]);
            info.arrive[0] = points[end][0]; 
            info.arrive[1] = points[end][1]; 
            info.que = que;
            infos[i] = info;
        }
        
        
        int[][] check = new int[maxC + 1][maxR + 1];
        for (int i = 0; i < infos.length; i++){
            if (infos[i].done) continue;
            int y = infos[i].r;
            int x = infos[i].c;
            if (x >= 0 && y >= 0 && x <= maxC && y <= maxR) {
                check[x][y]++;
                if (check[x][y] == 2) answer++; 
            }
        }
        
        while (count > 0) {
            check = new int[maxC + 1][maxR + 1];
            
            for (int i = 0; i < infos.length; i++) {
                Info cur = infos[i];
                if (cur.done) continue; 
                
                int rr = cur.r;               
                int rc = cur.c;                
                int ar = cur.arrive[1];         
                int ac = cur.arrive[0];         
                
                if (rr == ar && rc == ac) {
                    count--;
                    
                    if (!cur.que.isEmpty()) {
                        int next = cur.que.poll();
                        cur.arrive[0] = points[next][0]; 
                        cur.arrive[1] = points[next][1]; 
                        
                        ar = cur.arrive[1];
                        ac = cur.arrive[0];
                    } else {
                        cur.done = true;
                        continue; 
                    }
                }
                
                if (rc > ac) {
                    rc--;
                } else if (rc < ac) {
                    rc++;
                } else if (rr > ar) {
                    rr--;
                } else if (rr < ar) {
                    rr++;
                }
                
                cur.r = rr;
                cur.c = rc;
                
                if (!cur.done) { 
                    if (rc >= 0 && rr >= 0 && rc <= maxC && rr <= maxR) {
                        check[rc][rr]++;
                        if (check[rc][rr] == 2) {
                            answer++;
                        }
                    }
                }
            }
        }
        
        return answer;
    }

}



