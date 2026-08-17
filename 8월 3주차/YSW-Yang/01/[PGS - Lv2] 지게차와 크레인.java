import java.util.*;
class Solution {
    public boolean[][] removed;
    public int n;
    public int m;
    
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        n = storage.length;
        m = storage[0].length();
        removed = new boolean[n][m];
        answer = n*m;
        
        for(String request : requests){
            List<int[]> list = new ArrayList<>();
            if(request.length() == 1){
                list = bfs(storage, request.charAt(0));
            }else{
                for(int i = 0; i < n; i++){
                    for(int j = 0; j < m; j++){
                        if(request.charAt(0) == storage[i].charAt(j) && !removed[i][j]){
                            removed[i][j] = true;
                            answer--;
                        }
                    }
                }
            }
            
            for(int[] point : list){
                removed[point[0]][point[1]] = true;
                answer--;
            }
        }
        return answer;
    }
    
    public List<int[]> bfs(String[] storage, char target){
        Queue<int[]> queue = new ArrayDeque<>();
        List<int[]> list = new ArrayList<>();
        boolean[][] visited = new boolean[n][m];
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        for(int i = 0; i < n; i++){
            queue.add(new int[] {i, -1});
            queue.add(new int[] {i, m});
        }
        for(int i = 0; i < m; i++){
            queue.add(new int[] {-1, i});
            queue.add(new int[] {n, i});
        }
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int[] direction : directions){
                int newRow = cur[0] + direction[0];
                int newCol = cur[1] + direction[1];
                
                if(newRow < 0 || newRow >= n || newCol < 0 || newCol >= m){
                    continue;
                }
                
                if(visited[newRow][newCol]){
                    continue;
                }
                
                if(removed[newRow][newCol]){
                    queue.add(new int[] {newRow, newCol});
                    visited[newRow][newCol] = true;
                }else if(storage[newRow].charAt(newCol) == target){
                    list.add(new int[] {newRow, newCol});
                    visited[newRow][newCol] = true;
                }
            }
        }
        
        return list;
    }
}
