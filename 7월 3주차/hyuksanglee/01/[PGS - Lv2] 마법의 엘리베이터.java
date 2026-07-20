import java.util.*;

class Solution {
    
    class Info {
        int count;
        int total; 

        Info(int count, int total) {
            this.count = count;
            this.total = total;
        }
    }
    
    public int solution(int storey) {
        Queue<Info> que = new ArrayDeque<>();
        Map<Integer, Integer> minCounts = new HashMap<>();
        
        que.add(new Info(0, storey));
        minCounts.put(storey, 0);
        
        int answer = Integer.MAX_VALUE;
        
        while (!que.isEmpty()) {
            Info data = que.poll();
            
            if (data.total == 0) {
                answer = Math.min(answer, data.count);
                continue;
            }
            
            if (data.count > minCounts.getOrDefault(data.total, Integer.MAX_VALUE)) {
                continue;
            }
             
            int remainder = data.total % 10;
            
            if (remainder == 0) {
                int nextTotal = data.total / 10;
                if (data.count < minCounts.getOrDefault(nextTotal, Integer.MAX_VALUE)) {
                    minCounts.put(nextTotal, data.count);
                    que.add(new Info(data.count, nextTotal));
                }
                continue;
            }
            
            int downTotal = data.total / 10;
            int downCount = data.count + remainder;
            if (downCount < minCounts.getOrDefault(downTotal, Integer.MAX_VALUE)) {
                minCounts.put(downTotal, downCount);
                que.add(new Info(downCount, downTotal));
            }
            
            int upTotal = (data.total / 10) + 1;
            int upCount = data.count + (10 - remainder);
            if (upCount < minCounts.getOrDefault(upTotal, Integer.MAX_VALUE)) {
                minCounts.put(upTotal, upCount);
                que.add(new Info(upCount, upTotal));
            }
        }
        
        return answer;
    }
}
