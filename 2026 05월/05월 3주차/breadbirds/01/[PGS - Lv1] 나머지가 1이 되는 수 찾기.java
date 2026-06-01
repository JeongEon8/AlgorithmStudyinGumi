class Solution {
    public int solution(int n) {
        int answer = 0;
        int x = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++){
            if(n % i == 1){
               answer = Math.min(x, i);
                break;
            }
        }
        
        return answer;
    }
}
