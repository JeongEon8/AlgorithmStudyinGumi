class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        int N = m;
        int M = n;
        char[][] charBoard = new char[N][M];
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                charBoard[i][j] = board[i].charAt(j);
            }
        }
        
        boolean isFound = true;
        while(isFound){
            isFound = false;
            int[][] copyBoard = new int[N][M];
            for(int i = 0; i < N - 1; i++){
                for(int j = 0; j < M - 1; j++){
                    if(charBoard[i][j] != '.' && (charBoard[i][j] == charBoard[i + 1][j] && charBoard[i][j] == charBoard[i][j + 1] && charBoard[i][j] == charBoard[i + 1][j + 1])){
                        copyBoard[i][j] = 1;
                        copyBoard[i + 1][j] = 1;
                        copyBoard[i][j + 1] = 1;
                        copyBoard[i + 1][j + 1] = 1;
                        isFound = true;
                    }
                }
            }
            
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(copyBoard[i][j] == 1){
                        charBoard[i][j] = '.';
                    }
                }
            }
            
            for(int j = 0; j < M; j++){
                for(int i = N - 3; i >= 0; i--){
                    if(charBoard[i][j] == '.'){
                        continue;
                    }
                    
                    for(int k = i + 1; k < N; k++){
                        if(charBoard[k][j] == '.'){
                            charBoard[k][j] = charBoard[k - 1][j];
                            charBoard[k - 1][j] = '.';
                        }
                    }
                }
            }
        }
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(charBoard[i][j] == '.'){
                    answer++;
                }
            }
        }
        
        return answer;
    }
}
