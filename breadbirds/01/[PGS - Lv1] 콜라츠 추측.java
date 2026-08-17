class Solution {
    public int solution(long num) {
        int answer = 0;
        
        if (num == 1) return 0;
        
        while (num != 1) {
            if (answer >= 500) return -1;
            
            if (num % 2 == 0) {
                num = num / 2;
            } else {
                num = num * 3 + 1;
            }
            answer++;
        }
        
        return answer;
    }
}