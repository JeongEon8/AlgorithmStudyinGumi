class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        
        while (n > 0) {
            int remainder = n % 3;
            
            if (remainder == 0) {
                remainder = 4;
                n = n / 3 - 1;
            } else {
                n /= 3;
            }
            
            sb.append(remainder);
        }
        
        return sb.reverse().toString();
    }
}
