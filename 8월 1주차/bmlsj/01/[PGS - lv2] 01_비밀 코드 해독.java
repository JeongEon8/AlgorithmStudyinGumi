import java.util.*;
class Solution {
    static int answer;
    public int solution(int n, int[][] q, int[] ans) {
        answer = 0;
        
        selected = new int[5];
        comb(1, 0, n, q, ans);
        
        return answer;
    }
    
    static int[] selected;
    static void comb(int start, int idx, int n, int[][] q, int[] ans) {
        
        if (idx == 5) {
            
            boolean isPossible = true;
            for(int k = 0; k < q.length; k++) {
                int[] arr = q[k];
                int cnt = 0;
                
                for(int i = 0; i < 5; i++) {
                    for(int j = 0; j < 5; j++) {
                        if (selected[i] == arr[j]) {
                            cnt++;
                            break;
                        }
                    }
                }
                
                if (cnt != ans[k]) {
                    isPossible = false;
                    break;
                }
            }
            
            if (isPossible) {
                answer++;
            }
            
            return;
        }
        
        for(int i = start; i <= n; i++) {
            selected[idx] = i;
            comb(i + 1, idx + 1, n, q, ans);
        }
    }
    

}