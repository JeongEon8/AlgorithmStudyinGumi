import java.util.*;
class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);
        
        for(int i = 0; i < weights.length; i++){
            double w = weights[i]; 
            answer += countTarget(weights, i + 1, weights.length, w);
            answer += countTarget(weights, i + 1, weights.length, w * 3 / 2);
            answer += countTarget(weights, i + 1, weights.length, w * 2);
            answer += countTarget(weights, i + 1, weights.length, w * 4 / 3);
        }
        return answer;
    }
    
    private int countTarget(int[] weights, int start, int end, double target) {
        int leftIndex = lowerBound(weights, start, end, target);
        int rightIndex = upperBound(weights, start, end, target);
        return rightIndex - leftIndex;
    }
    
    public int lowerBound(int[] weights, int start, int end, double target){
        int left = start;
        int right = end;
        while(left < right){
            int mid = left + (right - left) / 2;
            
            if(weights[mid] >= target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    public int upperBound(int[] weights, int start, int end, double target){
                int left = start;
        int right = end;
        while(left < right){
            int mid = left + (right - left) / 2;
            
            if(weights[mid] > target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        
        return left;
    }
}
