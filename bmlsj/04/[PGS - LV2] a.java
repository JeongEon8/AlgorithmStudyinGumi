import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        HashMap<String, Integer> dis = new HashMap<>();
        for(int i = 0; i < want.length; i++) {
            dis.put(want[i], number[i]);
        }
        
        for(int i = 0; i <= discount.length - 10; i++) {
            HashMap<String, Integer> tmp = new HashMap<>();
            
            for(int j = i; j < i + 10; j++) {
                tmp.put(discount[j], tmp.getOrDefault(discount[j], 0) + 1);
            }
            
            boolean check = true;
            for (int k = 0; k < want.length; k++) {
                if (tmp.getOrDefault(want[k], 0) != number[k]) {
                    check = false;
                    break;
                }
            }
            
            if (check) answer++;
        }
        
        return answer;
    }
}