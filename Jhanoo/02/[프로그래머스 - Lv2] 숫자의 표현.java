import java.util.*;

class Solution {
    public int solution(int n) {
        List<Integer> divisors = new ArrayList<>();
        
        int cnt = 0;
        for (int i = 1; i * i < 2 * n; i++) {
            if (2 * n % i == 0) {
                divisors.add(i);
                divisors.add(2 * n / i);
                cnt++;
            }
        }
        
        int answer = 0;
        
        // 2n = k(2a + k - 1), (k > 0, k는 짝수)
        for(int i = 0; i < cnt; i++) {
            int d1 = divisors.get(i * 2);
            int d2 = divisors.get(i * 2 + 1);
            
            
            if ((d2 - d1 + 1) % 2 == 0) {
                answer++;
            }
        }
        
        return answer;
    }
}