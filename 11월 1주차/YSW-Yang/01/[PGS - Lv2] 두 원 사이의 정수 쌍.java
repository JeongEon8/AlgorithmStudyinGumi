class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        long r1Sq = (long) r1 * r1;
        long r2Sq = (long) r2 * r2;
        for(int x = 1; x <= r2; x++){
            long xSq = (long) x * x;
            long maxY = (long) Math.floor(Math.sqrt(r2Sq - xSq));
            long minY = (long) Math.ceil(Math.sqrt(Math.max(0, r1Sq - xSq)));
            
            answer += maxY - minY + 1;
        }
        
        return answer * 4;
    }
}
