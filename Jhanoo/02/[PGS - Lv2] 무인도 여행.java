import java.util.*;

class Solution {
    
    static int rowSize;
    static int colSize;
    
    public int[] solution(String[] maps) {
        rowSize = maps.length;
        colSize = maps[0].length();
        
        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };
        
        boolean[][] visited = new boolean[rowSize][colSize];
        List<Integer> days = new ArrayList<>();
        
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (visited[i][j]) continue;
                
                visited[i][j] = true;
                if (maps[i].charAt(j) == 'X') continue;
                
                Queue<int[]> q = new ArrayDeque<>();
                q.offer(new int[] {i, j});
                
                int foods = 0;
                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    int r = cur[0];
                    int c = cur[1];
                    
                    foods += maps[r].charAt(c) - '0';
                    
                    for (int d = 0; d < 4; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];
                        
                        if (nr < 0 || nr >= rowSize || nc < 0 || nc >= colSize 
                            || visited[nr][nc] || maps[nr].charAt(nc) == 'X')
                            continue;
                        
                        q.offer(new int[] { nr, nc });
                        visited[nr][nc] = true;
                    }
                }
                
                days.add(foods);
            }
        } 
        if (days.isEmpty()) {
            days.add(-1);
        }
        days.sort((a, b) -> a - b);
        
        int[] answer = days.stream()
            .mapToInt(Integer::intValue)
            .toArray();
        
        return answer;
    }
}
