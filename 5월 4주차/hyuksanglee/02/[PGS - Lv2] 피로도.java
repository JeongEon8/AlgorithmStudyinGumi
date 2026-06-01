import java.util.*;

class Solution {
    
    class Info {
        int k; 
        int bit;  
        int count; 
        
        Info(int k, int bit, int count) {
            this.k = k;
            this.bit = bit;
            this.count = count;
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        int len = dungeons.length;
        
        Queue<Info> que = new ArrayDeque<>(); 
        
        for (int i = 0; i < len; i++) {
            int min = dungeons[i][0];
            int price = dungeons[i][1];
            
            int bit = 1 << i; 
            
            if (k >= min && k - price >= 0) {
                que.add(new Info(k - price, bit, 1));
            }
        }
        
        if (que.isEmpty()) return 0;
        
        while (!que.isEmpty()) {
            Info data = que.poll();
            int currentBit = data.bit;
            int currentK = data.k;
            
            if (answer < data.count) {
                answer = data.count;
            }
            
            for (int j = 0; j < len; j++) {
                int newMin = dungeons[j][0];
                int newPrice = dungeons[j][1];
                
                if ((currentBit & (1 << j)) == 0 && currentK >= newMin && currentK - newPrice >= 0) {
                    
                    que.add(new Info(currentK - newPrice, currentBit | (1 << j), data.count + 1));
                    
                }
            }
        }
        
        return answer;
    }
}
