class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = play(m, n, board);
        return answer;
    }
    
    public int play(int m, int n, String[] board) {
        char[][] boards = new char[m][];
        
        for (int i = 0; i < m; i++) {
            boards[i] = board[i].toCharArray();
        }
        
        int cnt = 0;
        
        while (true) {
            int removes = remove(m, n, boards);
            if (removes == 0) break;
            
            pullDown(m, n, boards);
            cnt += removes;
        }
        
        return cnt;
    }
    
    public int remove(int m, int n, char[][] boards) {
        boolean[][] removed = new boolean[m][n];
        
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                char cur = boards[i][j];
                
                if (cur == ' ') 
                    continue;
                
                if (cur != boards[i][j + 1]) 
                    continue;
                if (cur != boards[i + 1][j]) 
                    continue;
                if (cur != boards[i + 1][j + 1]) 
                    continue;
                
                removed[i][j] = true;
                removed[i][j + 1] = true;
                removed[i + 1][j] = true;
                removed[i + 1][j + 1] = true;
            }
        }
        
        int cnt = 0;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (removed[i][j]) {
                    boards[i][j] = ' ';
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
    
    public void pullDown(int m, int n, char[][] boards) {
        for (int j = 0; j < n; j++) {
            int blanks = 0;
            
            for (int i = m - 1; i >= 0; i--) {
                if (boards[i][j] == ' ') {
                    blanks++;
                } else if (blanks > 0) {
                    boards[i + blanks][j] = boards[i][j];
                    boards[i][j] = ' ';
                }
            }
        }
    }
    
}
