class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] board = new int[rows][columns];
        
        int num = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                board[r][c] = ++num;
            }
        }
        
        int[] dx = { 0, 1, 0, -1 };
        int[] dy = { 1, 0, -1, 0 };
        
        int[] answer = new int[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            
            int x1 = query[0] - 1;
            int y1 = query[1] - 1;
            int x2 = query[2] - 1;
            int y2 = query[3] - 1;
            
            int prev = board[x1 + 1][y1];
            int cur = board[x1][y1];
            int min = prev;
            
            board[x1][y1] = prev;
            prev = cur;
            
            int r = x1;
            int c = y1;
            int d = 0;
            
            while (r != x1 + 1 || c != y1) {
                if (r == x1 && c == y2) d++;
                if (r == x2 && c == y2) d++;
                if (r == x2 && c == y1) d++;
                
                r += dx[d];
                c += dy[d];
            
                min = Math.min(min, prev);
                
                cur = board[r][c];
                board[r][c] = prev;
                prev = cur;
            }
            
            answer[i] = min;
        }
        
        return answer;
    }
}
