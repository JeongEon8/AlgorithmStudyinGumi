import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Queue<String> que = new ArrayDeque<>();
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i<want.length; i++){
            map.put(want[i], number[i]);
        }
        int total = 10;
        for(int i = 0; i<10; i++){
            String prd = discount[i];
            que.add(prd);
            if (map.containsKey(prd)) {
                int nextCount = map.get(prd) - 1;
                map.put(prd, nextCount);
                
                if (nextCount >= 0) {
                    total -= 1;
                }
            }
        }
        if (total == 0) {
                answer++;
            }
        
        for(int i = 10; i<discount.length; i++){
            
            String bfPrd = que.poll();
            if (map.containsKey(bfPrd)) {
                int nextCount = map.get(bfPrd) + 1;
                map.put(bfPrd, nextCount);

                if (nextCount > 0) {
                    total += 1;
                }
            }
            
            String prd = discount[i];
            que.add(prd);
            if (map.containsKey(prd)) {
                int nextCount = map.get(prd) - 1;
                map.put(prd, nextCount);
                

                if (nextCount >= 0) {
                    total -= 1;
                }
            }
            if (total == 0) {
                answer++;
            }
        }
        
        return answer;
    }
}
