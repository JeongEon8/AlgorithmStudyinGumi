package programmers;

public class Pragrammers_혼자서하는틱택토 {

	static int[] di = {0,1,1,1};
    static int[] dj = {1,1,0,-1};
    static int countO, countX;
    static char[][] map;
    public int solution(String[] board) {
        int answer = 1;
        countO = 0;
        countX = 0;
        map = new char[3][3];
        boolean[][] check = new boolean[3][3];
        
        
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                char c = board[i].charAt(j);
                if(c=='O'){
                    countO++;
                }else if(c=='X'){
                    countX++;
                }
               map[i][j] = c;
            }
        }
        
        if(countO<countX){
            return 0;
        }
        
        if(countO-countX>1){
            return 0;
        }
        
         for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                if(map[i][j] != '.' && !check[i][j]){
                    check[i][j] =true;
                    if(bfs(i, j, map[i][j])){
                        if(map[i][j]=='O' && countO<= countX){
                            return 0;
                        }else if(map[i][j]=='X' && countO!= countX){
                            return 0;
                        }
                    }
                }
            }
         }
        
        return answer;
    }
    
    static boolean bfs(int i, int j, char c){
        for(int d= 0; d<4; d++){
            int ni = i + di[d];
            int nj = j + dj[d];
            
            if(ni <0 || ni>=3 || nj < 0 || nj>=3){
                continue;
            }
            
            if(map[ni][nj] == c){
                ni += di[d];
                nj += dj[d];
                if(ni <0 || ni>=3 || nj < 0 || nj>=3){
                    continue;
                }
                if(map[ni][nj] == c){
                    return true;
                }
                
            }
        }
        return false;
    }

}
