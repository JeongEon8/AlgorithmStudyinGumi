class Solution {
    private int[] answer;
    public int[] solution(int[][] arr) {
        answer = new int[2];
        divideAndConquer(arr, 0, 0, arr.length);
        
        return answer;
    }
    
    public void divideAndConquer(int[][] arr, int r, int c, int size){
        if(isSame(arr, r, c, size)){
            answer[arr[r][c]]++;
            return;
        }
        int nextSize = size / 2;
        
        divideAndConquer(arr, r, c, nextSize);
        divideAndConquer(arr, r, c + nextSize, nextSize);
        divideAndConquer(arr, r + nextSize, c, nextSize);
        divideAndConquer(arr, r + nextSize, c + nextSize, nextSize);
    }
    
    public boolean isSame(int[][] arr, int r, int c, int size){
        int baseValue = arr[r][c];
        
        for(int i = r; i < r + size; i++){
            for(int j = c; j < c + size; j++){
                if(baseValue != arr[i][j]){
                    return false;
                }
            }
        }
        
        return true;
    }
}
