class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        long[] count = new long[1001];
        for(int weight: weights){
            count[weight]++;
        }
        for(int i = 1; i<=1000; i++){
            long currentCnt = count[i];
            if(currentCnt==0) continue;
            answer+= currentCnt * (currentCnt-1) / 2;
            
            if(i * 3 % 2 == 0 && i * 3 / 2 <= 1000) {
                answer += currentCnt * count[i * 3 / 2];
            }
            
            if(i * 2 <= 1000) {
                answer += currentCnt * count[i * 2];
            }
            
            if(i * 4 % 3 == 0 && i * 4 / 3 <= 1000) {
                answer += currentCnt * count[i * 4 / 3];
            }
            
            
        }
        return answer;
    }
}