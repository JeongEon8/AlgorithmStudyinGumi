package 고득점Kit;

import java.util.Arrays;

public class Programmers_K번째수 {

	public int[] solution(int[] array, int[][] commands) {
        int len = commands.length;
        int index=0;
        int[] answer = new int[len];
        
        for(int i =0; i<len; i++){
            // answer[i] = commands[i][1];
            int start = commands[i][0];
            int end = commands[i][1];
            int type = commands[i][2];
            
            int[] arr= new int [end-start+1];
            int indexA = 0;
            for(int j = start-1; j<end; j++){
                arr[indexA++] = array[j];
            }
            
            Arrays.sort(arr);
            
            answer[index++] = arr[type-1];
        }
        
        
        return answer;
    }

}
