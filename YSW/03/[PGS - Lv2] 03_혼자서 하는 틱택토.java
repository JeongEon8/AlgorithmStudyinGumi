
class Solution {
    public int solution(String[] board) {
        int oCount = 0;
        int xCount = 0;
        
        for(String s : board){
            for(int i = 0; i < 3; i++){
                if(s.charAt(i) == 'O'){
                    oCount++;
                }else if(s.charAt(i) == 'X'){
                    xCount++;
                }
            }
        }
        
        if(oCount > xCount + 1 || oCount < xCount || (oCount != xCount + 1 && isBingo(board, 'O')) || (oCount != xCount && isBingo(board, 'X'))){
            return 0;
        }
        
        return 1;
    }
    
    public boolean isBingo(String[] board, char target){
        for(int i = 0; i < 3; i++){
            if(board[i].charAt(0) == target && board[i].charAt(1) == target && board[i].charAt(2) == target){
                return true;
            }
            if(board[0].charAt(i) == target && board[1].charAt(i) == target && board[2].charAt(i) == target){
                return true;
            }
        }
        
        if(board[0].charAt(0) == target && board[1].charAt(1) == target && board[2].charAt(2) == target){
            return true;
        }
        if(board[0].charAt(2) == target && board[1].charAt(1) == target && board[2].charAt(0) == target){
            return true;
        }
        
        return false; 
    }
}