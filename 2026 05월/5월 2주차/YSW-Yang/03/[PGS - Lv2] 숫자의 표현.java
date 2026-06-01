class Solution {
    public int solution(int n) {
        int answer = 0;
        int left = 1;
        int right = 1;
        
        int sum = 0;
        while(left <= n){
            if(sum > n){
                sum -= left;
                left++;
            }else{
                if(sum == n){
                    answer++;
                }
                sum += right;
                right++;
            }
        }
        
        return answer;
    }
} 
