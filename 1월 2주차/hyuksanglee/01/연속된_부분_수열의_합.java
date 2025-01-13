package programmers;

import java.util.*;
class Solution {
    
    public int[] solution(int[] sequence, int k) {
        
        int count =0;
        int num = 0;
        int index =0;
        int total = 0;
        int[] answer = new int[2];
        int minC = Integer.MAX_VALUE;
        
        Queue que = new ArrayDeque();
        for(int i= 0; i<sequence.length; i++){
            if(k<sequence[i]){
                break;
            }
            total+= sequence[i];
            count+=1;
            while(total>k){
                total-= sequence[index++];
                count--;
            }
            if(total==k && minC>count){
                minC=count;
                answer[0]= index;
                answer[1] = i;
            }
        }
        
        return answer;
    }
}