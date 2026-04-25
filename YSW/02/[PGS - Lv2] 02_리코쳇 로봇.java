import java.util.*;

class Solution {
    public int solution(String[] board) {
        int answer = -1;
        int N = board.length;
        int M = board[0].length();
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        int[][] directions = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
        
        boolean foundStratPoint = false;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(board[i].charAt(j) == 'R'){
                    queue.add(new int[] { i, j });
                    visited[i][j] = true;
                    foundStratPoint = true;
                    break;
                }
            }
            if(foundStratPoint) break;
        }
        
        int count = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            
            while(size-- > 0){
                int[] curr = queue.poll();
                int row = curr[0];
                int col = curr[1];
                if(board[row].charAt(col) == 'G'){
                    return count;
                }
                
                for(int i = 0; i < 4; i++){
                    int newRow = row;
                    int newCol = col;
                    while(newRow >= 0 && newRow < N && newCol >= 0 && newCol < M ){
                        if(board[newRow].charAt(newCol) == 'D'){
                            break;
                        }
                        newRow += directions[i][0];
                        newCol += directions[i][1]; 
                    }
                    newRow -= directions[i][0];
                    newCol -= directions[i][1];
                    
                    if(!visited[newRow][newCol]){
                        queue.add(new int[] {newRow, newCol});
                        visited[newRow][newCol] = true;
                    }
                }
            }
            count++;
        }
        
        return answer;
    }
}