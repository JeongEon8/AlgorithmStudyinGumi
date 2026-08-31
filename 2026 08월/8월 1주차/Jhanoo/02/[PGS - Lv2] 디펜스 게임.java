import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int soldier = n;
        int i;
        for (i = 0; i < enemy.length; i++) {
            pq.offer(enemy[i]);
            soldier -= enemy[i];
            
            while (soldier < 0 && k > 0) {
                soldier += pq.poll();
                k--;
            }
            
            if (soldier < 0 && k == 0) {
                break;
            }
        }
        
        return i;
    }
}
