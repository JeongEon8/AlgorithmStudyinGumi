import java.util.*;
class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            map.put(enroll[i], i);
        }
        
        
        for(int i = 0; i < seller.length; i++) {
            
            String curr = seller[i];
            int money = amount[i] * 100;
            
            while(!curr.equals("-") && money > 0) {
                int curIdx = map.get(curr);
                int tip = money / 10;

                answer[curIdx] += money - tip;
                curr = referral[curIdx];
                money = tip;
            }
        }
        
        
        
        return answer;
    }
}