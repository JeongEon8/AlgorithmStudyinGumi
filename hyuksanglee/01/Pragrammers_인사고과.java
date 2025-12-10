package programmers;

import java.util.Arrays;

public class Pragrammers_인사고과 {

	public int solution(int[][] scores) {
        int answer = 1;
        int scoreW = scores[0][0];
        int scoreC = scores[0][1];
        int total = scoreW+ scoreC;
        
        Arrays.sort(scores, (a,b)->{
            if (a[0] != b[0]) return b[0] - a[0];
            return a[1] - b[1]; 
        });
        
        int pw = scores[0][0];
        int pc = scores[0][1];
        for(int i = 0; i<scores.length; i++){
            int w = scores[i][0];
            int c = scores[i][1];
            int t = w+c;
            
            if(scoreW<w && scoreC<c){
                return -1;
            }
            
            if(w<pw && c < pc){
                continue;
            }
            
            pw=w; 
            pc=c;
            if(total<t){
                answer ++;
            }
            
            
        }
        
        return answer;
    }

}
