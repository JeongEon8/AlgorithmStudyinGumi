class Solution {
    public int solution(String dirs) {
        int answer = 0;
        boolean[][][][] visited = new boolean[11][11][11][11];
        int row = 5;
        int col = 5;
        
        for(int i = 0; i < dirs.length(); i++){
            int nextRow = row;
            int nextCol = col;
            if(dirs.charAt(i) == 'U'){
                if(row - 1 >= 0){
                    nextRow--;
                }
            }else if(dirs.charAt(i) == 'D'){
                if(row + 1 <= 10){
                    nextRow++;
                }
            }else if(dirs.charAt(i) == 'L'){
                if(col - 1 >= 0){
                    nextCol--;
                }
            }else if(dirs.charAt(i) == 'R'){
                if(col + 1 <= 10){
                    nextCol++;
                }
            }
            
            if(!visited[row][col][nextRow][nextCol] && !(row == nextRow && col == nextCol)){
                visited[row][col][nextRow][nextCol] = true;
                visited[nextRow][nextCol][row][col] = true;
                answer++;
            }
            
            row = nextRow;
            col = nextCol;
        }
        
        return answer;
    }
}