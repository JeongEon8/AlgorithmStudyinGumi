class Solution {
    public int[] solution(long begin, long end) {
        int n = (int) (end - begin) + 1;
        int[] answer = new int[n];
        
        for(long i = begin; i <= end; i++){
            int index = (int)(i - begin);
            if(i == 1){
                continue;
            }
            
            long maxDivision = 1;
            for(int j = 2; j <= Math.sqrt(i); j++){
                if(i % j == 0){
                    if(i / j <= 10_000_000){
                        maxDivision = i / j;
                        break;
                    }
                    
                    maxDivision = j;
                }
            }
            answer[index] = (int) maxDivision;
        }
        
        return answer;
    }
}
