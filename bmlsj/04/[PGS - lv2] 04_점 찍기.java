class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        // x2+y2 ≤ d2 원 안에 있는 점의 갯수
        for (long x = 0; x <= d; x += k) {
            long y = (long)Math.sqrt((long)d*d - x*x);
            answer += y / k + 1;
        }
        
        return answer;
    }
}