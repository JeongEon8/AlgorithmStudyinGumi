import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        long total = 0;
        for(int num : queue1) total += num;
        for(int num : queue2) total += num;

        if(total % 2 != 0) return -1;
        total /= 2;

        Queue<Long> q1 = new ArrayDeque<>();
        Queue<Long> q2 = new ArrayDeque<>();
        long q1_sum = 0, q2_sum = 0;
        
        for(int i = 0; i < queue1.length; i++) {
            long num = queue1[i];
            q1.add(num);
            q1_sum += num;
        }
        for(int i = 0; i < queue2.length; i++) {
            long num = queue2[i];
            q2.add(num);
            q2_sum += num;
        }

        while(q1_sum != total) {
            
            if (answer > (queue1.length + queue2.length) * 3) {
                return -1;
            }
            
            if (q1_sum < total) {
                long insert = q2.poll();
                q1.add(insert);
                q2_sum -= insert;
                q1_sum += insert;

            } else {
                long insert = q1.poll();
                q2.add(insert);
                q1_sum -= insert;
                q2_sum += insert;
                
            }
            answer++;
            
        }

        return answer;
    }
}
