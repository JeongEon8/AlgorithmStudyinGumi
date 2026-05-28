class Solution {
    public String solution(int n) {
        
        String answer = "";
        String[] numbers = {"4", "1", "2"};

        while(n > 0) {
            int re = n % 3;
            answer = numbers[re] + answer;
            
            n = (int)Math.floor((n - 1) / 3);
        }
        return answer;
    }
}