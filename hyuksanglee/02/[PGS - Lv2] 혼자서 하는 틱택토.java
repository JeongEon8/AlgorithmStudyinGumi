class Solution {
    public int solution(String[] board) {
        int countX = 0;
        int countO = 0;
       
        
        int[] dx = {0, 1, 1};
        int[] dy = {1, 1, 0};
        
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                char c = board[i].charAt(j);
                if(c=='X'){
                    countX++; 
                }else if(c == 'O'){
                    countO++;
                }
            }
        }
        
        boolean bingoO = isWin(board,'O');
        boolean bingoX = isWin(board,'X');
        
        
       if (countO < countX || countO - countX > 1) {
            return 0;
        }
        
         if (bingoO && bingoX) {
            return 0;
        }
        if (bingoO && countO == countX) {
            return 0;
        }
        if (bingoX && countO > countX) {
            return 0;
        }
        
        
        int answer = 1;
        return answer;
    }
    
 
    private boolean isWin(String[] board, char c) {
        
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == c && board[i].charAt(1) == c && board[i].charAt(2) == c) return true;
            if (board[0].charAt(i) == c && board[1].charAt(i) == c && board[2].charAt(i) == c) return true;
        }
        
 
        if (board[0].charAt(0) == c && board[1].charAt(1) == c && board[2].charAt(2) == c) return true;
        if (board[0].charAt(2) == c && board[1].charAt(1) == c && board[2].charAt(0) == c) return true;
        
        return false;
    }
    
    
}
