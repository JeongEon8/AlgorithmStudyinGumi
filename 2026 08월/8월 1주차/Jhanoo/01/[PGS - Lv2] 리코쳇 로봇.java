import java.util.*;

class Solution {
    public int solution(String[] board) {
        int rowSize = board.length;
        int colSize = board[0].length();
        
        int startRow = -1;
        int startCol = -1;
        int goalRow = -1;
        int goalCol = -1;
        
        for (int r = 0; r < rowSize; r++) {
            for (int c = 0; c < colSize; c++) {
                char cell = board[r].charAt(c);
                
                if (cell == 'R') {
                    startRow = r;
                    startCol = c;
                } else if (cell == 'G') {
                    goalRow = r;
                    goalCol = c;
                }
            }
        }
        
        int[][] visited = new int[rowSize][colSize];
        for (int[] row : visited) {
            Arrays.fill(row, -1);
        }
        
        Queue<int[]> q = new ArrayDeque<>();
        
        q.offer(new int[] {startRow, startCol});
        visited[startRow][startCol] = 0;
        
        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            
            if (r == goalRow && c == goalCol) {
                return visited[r][c];
            }
            
            for (int d = 0; d < 4; d++) {
                int nextRow = r;
                int nextCol = c;
                
                while (true) {
                    int nr = nextRow + dr[d];
                    int nc = nextCol + dc[d];
                    
                    if (nr < 0 || nr >= rowSize || nc < 0 || nc >= colSize || board[nr].charAt(nc) == 'D')
                        break;
                    
                    nextRow = nr;
                    nextCol = nc;
                }
                
                if (visited[nextRow][nextCol] != -1) 
                    continue;
                
                visited[nextRow][nextCol] = visited[r][c] + 1;
                q.offer(new int[] {nextRow, nextCol});
            }
        }
        
        return -1;
    }
}
