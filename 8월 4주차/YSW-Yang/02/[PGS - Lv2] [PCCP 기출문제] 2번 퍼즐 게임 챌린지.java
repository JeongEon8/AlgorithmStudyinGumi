class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int left = 1;
        int right = 0; 
        
        for(int i = 0; i < diffs.length; i++){
            right = Math.max(right, diffs[i]);
        }
        
        answer = right;
        while(left <= right){
            int mid = left + (right - left) / 2;
            long currentTime = 0;
            for(int i = 0; i < diffs.length; i++){
                int diff = diffs[i];
                
                if(mid >= diff){
                    currentTime += times[i];
                }else{
                    long count = diff - mid;
                    currentTime += ((long)(times[i - 1] + times[i]) * count) + times[i];
                }
                
                if(currentTime > limit){
                    break;
                }
            }
            
            if(currentTime <= limit){
                answer = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        
        return answer;
    }
}
