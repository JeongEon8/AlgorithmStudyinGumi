class Solution {
    
    int[][] arr;
    int[] answer = new int[2];
    
    public int[] solution(int[][] arr) {
        this.arr = arr;
    
        quad(0, 0, arr.length);
        
        return answer;
    }
    
    private void quad(int row, int col, int size) {
        int value = arr[row][col];
        boolean same = true;
        
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (arr[i][j] != value) {
                    same = false;
                    break;
                }
            }
            if (!same) break;
        }
        
        if (same) {
            answer[value]++;
            return;
        }

        int half = size / 2;

        quad(row, col, half);                 // 왼쪽 위
        quad(row, col + half, half);          // 오른쪽 위
        quad(row + half, col, half);          // 왼쪽 아래
        quad(row + half, col + half, half);   // 오른쪽 아래
    }
}
