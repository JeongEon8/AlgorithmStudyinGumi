package programmers;
import java.util.*;

public class Pragrammers_지게차크레인 {

	static int[] di = {1,0,-1,0};
    static int[] dj = {0,1,0,-1};
    static char[][] arr;
    static boolean[][]check;
    static int answer, n, m;
    static class Info{
        int i;
        int j;
        Info(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    
    public int solution(String[] storage, String[] requests) {
        n = storage.length;
        m = storage[0].length();
        arr = new char[n][m];
        answer = n*m;
        
        int count = 0;
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                arr[i][j] = storage[i].charAt(j);
            }
        }
        
        for(int i = 0; i<requests.length; i++){
            char find = requests[i].charAt(0);
            count++;
            if(requests[i].length()>1){
                for( int c = 0; c<n; c++){
                    for(int r = 0; r<m; r++){
                        if(arr[c][r]==find){
                            arr[c][r]=' ';
                            answer--;
                        }
                    }
                }
            }else{
                check = new boolean[n][m];
                
               for(int k=0; k<m; k++){
                   if(arr[0][k] == find){
                       check[0][k] =true;
                        arr[0][k]=' ';
                            answer--;
                   }else if(!check[0][k] && arr[0][k]==' '){
                       bfs(0,k,find);
                   }
                   
                    if(arr[n-1][k] == find){
                       check[n-1][k] =true;
                        arr[n-1][k]=' ';
                            answer--;
                   }else if(!check[n-1][k] && arr[n-1][k]==' '){
                       bfs(n-1,k,find);
                   }
                   
               }
                
                for(int k=0; k<n; k++){
                   if(arr[k][0] == find){
                       check[k][0] =true;
                        arr[k][0]=' ';
                            answer--;
                   }else if(!check[k][0] && arr[k][0]==' '){
                       bfs(k,0,find);
                   }
                   
                    if(arr[k][m-1] == find){
                       check[k][m-1] =true;
                        arr[k][m-1]=' ';
                            answer--;
                   }else if(!check[k][m-1] && arr[k][m-1]==' '){
                       bfs(k,m-1,find);
                   }
                   
               }
            }
        }
        
        
        return answer;
    }
    
    static void bfs(int i, int j, char find){
        Queue<Info>que = new ArrayDeque<Info>();
        Info info = new Info(i ,j);
        que.add(info);
        
        while(!que.isEmpty()){
            Info infoN = que.poll();
            int ni = infoN.i;
            int nj = infoN.j;
            for(int d = 0; d<4; d++){
                int ci =ni+di[d];
                int cj = nj + dj[d];
                if(ci<0|| ci>=n || cj < 0 || cj>=m){
                    continue;
                }
                if(!check[ci][cj] && arr[ci][cj]==' '){
                    Info infoM = new Info(ci,cj);
                    check[ci][cj] = true;
                    que.add(infoM);
                }else if(arr[ci][cj]== find){
                    check[ci][cj] = true;
                    answer--;
                    arr[ci][cj]=' ';
                }
            }
        }
    }

}
