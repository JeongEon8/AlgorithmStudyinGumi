import java.util.*;
class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        int sum = 0;
        int left = 0;
        int minLength = Integer.MAX_VALUE;
        for(int right = 0; right < sequence.length; right++){
            sum += sequence[right];
            
            while(sum > k){
                sum -= sequence[left];
                left++;
            }
            
            if(sum == k){
                if(minLength > right - left){
                    minLength = right - left;
                    answer[0] = left;
                    answer[1] = right;
                }
            }
        }
        return answer;
    }
}