class Solution {
    public long solution(int w, int h) {
        long answer = (long) w * h;
        
        return answer - (w + h - gcd(w, h));
    }
    
    private long gcd(long a, long b){
        while(b != 0){
            long temp = a % b;
            a = b;
            b = temp;
        }
        
        return a;
    }
}
