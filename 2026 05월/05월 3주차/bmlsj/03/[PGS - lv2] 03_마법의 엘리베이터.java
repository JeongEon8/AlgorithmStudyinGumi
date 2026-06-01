class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while(storey > 0) {
            int digit = storey % 10;
            
            if (digit > 5) { // 절반 이상일 경우, 빼기
                answer += 10 - digit;
                storey += 10;
            } else if (digit < 5) {
                answer += digit;
            } else {
                int next = (storey / 10 ) % 10;
                answer += 5;
                if (next >= 5) {
                    storey += 10;
                }
            }
            
            storey /= 10;
        }
        return answer;
    }
}