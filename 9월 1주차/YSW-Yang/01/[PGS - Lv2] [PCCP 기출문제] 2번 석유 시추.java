import java.util.*;
class Solution {
    public int solution(int[][] land) {
        int answer = 0;
        int n = land.length;
        int m = land[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        boolean[][] visited = new boolean[n][m];
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        
        int oilIndex = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(land[i][j] == 1 && !visited[i][j]){
                    queue.add(new int[] {i, j});
                    visited[i][j] = true;
                    oilIndex++;
                    land[i][j] = oilIndex;
                    int count = 1;
                    
                    while(!queue.isEmpty()){
                        int[] cur = queue.poll();
                        for(int[] direction: directions){
                            int nextRow = cur[0] + direction[0];
                            int nextCol = cur[1] + direction[1];
                            
                            if(nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m && land[nextRow][nextCol] == 1 && !visited[nextRow][nextCol]){
                                queue.add(new int[] {nextRow, nextCol});
                                visited[nextRow][nextCol] = true;
                                land[nextRow][nextCol] = oilIndex;
                                count++;
                            }
                        }
                    }
                    
                    hashmap.put(oilIndex, count);
                }
            }
        }
        
        for(int j = 0; j < m; j++){
            Set<Integer> hashset = new HashSet<>();
            int count = 0;
            for(int i = 0; i < n; i++){
                if(land[i][j] != 0){
                    hashset.add(land[i][j]);
                }
            }
            
            for(int key : hashset){
                count += hashmap.get(key);
            }
            
            answer = Math.max(answer, count);
        }
        
        return answer;
    }
}
