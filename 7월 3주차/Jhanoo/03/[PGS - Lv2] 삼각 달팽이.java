class Solution {
    public int[] solution(int n) {
        int[][] a = new int[n][n];
        
        int[] dr = {1, 0, -1};
        int[] dc = {0, 1, -1};
        
        int row = -1;
        int col = 0;
        int direction = 0;
        int num = 1;
        
        for (int length = n; length > 0; length--) {
            for (int i = 0; i < length; i++) {
                row += dr[direction];
                col += dc[direction];
                
                a[row][col] = num++;
            }
            
            direction = (direction + 1) % 3; 
        }
        
        int[] answer = new int[n * (n + 1) / 2];
        
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[idx++] = a[i][j];
            }
        }
        
        return answer;
    }
}
