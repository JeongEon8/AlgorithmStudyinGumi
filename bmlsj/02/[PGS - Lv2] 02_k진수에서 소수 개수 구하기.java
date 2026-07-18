class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String[] change = Integer.toString(n, k).split("0");
       
        for(String ch: change) {
            
            if (ch.equals("")) {
                continue;
            }
            
            long num = Long.parseLong(ch);
            if (isPrime(num)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    static boolean isPrime(long num) {
        if (num < 2) return false;
        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}