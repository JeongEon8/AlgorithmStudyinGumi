import java.util.*;
class Solution {
    
    static boolean[][] check;
    
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public int[] solution(String[] maps) {
        check = new boolean[maps.length][maps[0].length()];
        List<Integer> list = new ArrayList<>();
        for(int x =0; x<maps.length; x++){
            for(int y = 0; y<maps[0].length(); y++){
                if(maps[x].charAt(y) != 'X' && !check[x][y] ){
                    check[x][y] = true;
                    list.add(find(x, y, maps));
                }
            }
        }
        int[] answer = {-1};    
        if(list.size()>0){
          answer = list.stream().mapToInt(Integer::intValue).toArray();  
            Arrays.sort(answer);
        }
        
        
       
        return answer;
    }
    
    public int find(int x, int y, String[] maps){
        Queue<int[]>que = new ArrayDeque<>();
        que.add(new int[]{x,y});
        int total = maps[x].charAt(y) - '0';
        while(!que.isEmpty()){
            int[] data = que.poll();
            int cx = data[0];
            int cy = data[1];
            for(int d = 0; d<4; d++){
                int nx = dx[d]+ cx;
                int ny = dy[d]+cy;
                if(nx<0 || ny<0 || nx>=maps.length || ny>=maps[0].length()){
                    continue;
                }
                if(maps[nx].charAt(ny) != 'X' && !check[nx][ny]){
                    check[nx][ny]=true;
                    total+= maps[nx].charAt(ny) - '0';
                    que.add(new int[]{nx,ny});
                }
            }
        }
        
        return total;
    }
 
}
