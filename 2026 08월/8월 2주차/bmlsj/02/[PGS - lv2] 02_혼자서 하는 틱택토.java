class Solution {
    public int solution(String[] board) {
 
        int oCnt = 0, xCnt = 0;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == 'O') oCnt++;
                if (board[i].charAt(j) == 'X') xCnt++;
            }
        }
        
        if (oCnt < xCnt || oCnt > xCnt + 1) return 0;
        
        boolean oWins = isWinner(board, 'O');
        boolean xWins = isWinner(board, 'X');
        
        if (oWins && oCnt != xCnt + 1) return 0;
        if (xWins && oCnt != xCnt) return 0;
        
        return 1;
    }
    
    static boolean isWinner(String[] board, char target) {
        
        // 가로
        for(int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == target && 
                board[i].charAt(1) == target && 
                board[i].charAt(2) == target) return true;
        }
        
        // 세로
        for(int i = 0; i < 3; i++) {
            if (board[0].charAt(i) == target && 
                board[1].charAt(i) == target && 
                board[2].charAt(i) == target) return true;
        }
        
        // 대각선
        if (board[0].charAt(0) == target &&
            board[1].charAt(1) == target &&
            board[2].charAt(2) == target) return true;
        
        // 반대 대각선
        if (board[0].charAt(2) == target &&
           board[1].charAt(1) == target &&
           board[2].charAt(0) == target) return true;
        
        return false;
    }
 
}