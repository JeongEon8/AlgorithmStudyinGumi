class Solution {
    public long solution(long n) {
        long answer = 0;
        
        long x = (long) Math.sqrt(n);
        
        if (x*x == n) {
            answer = (x+1) * (x+1);
        } else return -1;
        
        return answer;
    }
}
