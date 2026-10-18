import java.util.*;
class Solution {
    
    static String[] maps;
    static boolean[][] check;
    public int[] solution(String[] maps) {
        this.maps = maps;
        
        check = new boolean[maps.length][maps[0].length()];
        
        List<Integer> list = new ArrayList();
        for(int i = 0; i<maps.length; i++){
           for(int j = 0; j<maps[0].length(); j++){
                char c = maps[i].charAt(j); 
               if(!check[i][j] && c!='X'){
                    check[i][j] = true;
                    list.add(bfs(i,j));
                }
            } 
        }
        int[] answer = new int[list.size()];
        int index =0;
        for(int n : list){
            answer[index++] = n;
        }
        Arrays.sort(answer);
        if(list.size()==0){
            answer = new int[]{-1};
        }
        
        return answer;
    }
    
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static class Info{
        int r;
        int c;
        Info(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public int bfs(int r, int c){
        Queue<Info> que = new ArrayDeque<>();
        que.add(new Info(r,c));
        int total = 0;
        while(!que.isEmpty()){
            Info info = que.poll();
            int nr = info.r;
            int nc = info.c;
            total += maps[nr].charAt(nc)-'0';
            for(int d = 0; d<4; d++){
                int cr = nr + dr[d];
                int cc = nc + dc[d];
                
                if(cr<0 || cc<0 || cr>= maps.length || cc>= maps[0].length()){
                    continue;
                }
                
                char ch = maps[cr].charAt(cc); 
                if(!check[cr][cc] && ch!='X'){
                    
                    check[cr][cc] = true;
                    que.add(new Info(cr,cc));
                }
            }
        }
        return total;
    }
}
