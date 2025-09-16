import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        
        Map<String, Integer> wantmap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantmap.put(want[i], number[i]);
        }

        int answer = 0;

        // discount 배열에서 10일 단위로 검사
        for (int i = 0; i <= discount.length - 10; i++) {
            Map<String, Integer> discountmap = new HashMap<>();

            // 현재 10일간의 상품 카운트
            for (int j = i; j < i + 10; j++) {
                discountmap.put(discount[j], discountmap.getOrDefault(discount[j], 0) + 1);
            }
          
            boolean ok = true;
            for (String key : wantmap.keySet()) {
                if (discountmap.getOrDefault(key, 0) < wantmap.get(key)) {
                    ok = false;
                    break;
                }
            }

            if (ok) answer++;
        }
        
        return answer;
    }
}
