import java.util.*;

class Solution {
    int[][] cost;
    int[][] hint;
    int[] sale;
    int total = 0;
    
    public int solution(int[][] cost, int[][] hint) {
        this.cost = cost;
        this.hint = hint;
        this.sale = new int[cost.length+1];
        int answer = 0;
        int step = hint.length;
        
        for(int i = 0; i<cost.length; i++){
            total += cost[i][0];
        }
        
        combo(0, step, new ArrayList<>());
        
        return total;
    }
    
    public void combo(int start, int n, List<Integer> cur){
        
        
        if (!cur.isEmpty()) {

            int tmp = 0;

            for (int idx : cur) {
                tmp += hint[idx][0];
            }

            for (int i = 0; i < cost.length; i++) {

                int useHint = Math.min(
                    sale[i + 1],
                    cost[i].length - 1
                );

                tmp += cost[i][useHint];
            }

            if (total > tmp) {
                total = tmp;
            }
        }
        
        for (int i = start; i < n; i++){
            cur.add(i);
            int[] data = hint[i];
            for(int j = 1; j<data.length; j++){
                sale[data[j]] += 1;
            }
            
            combo(i+1, n, cur);
            
           for(int j = 1; j<data.length; j++){
                sale[data[j]] -= 1;
            }
            
            cur.remove(cur.size() -1);
        }
    }
    
    
}
