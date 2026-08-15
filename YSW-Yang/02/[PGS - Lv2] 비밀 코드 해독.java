class Solution {
    int answer;
    int[] hints;
    
    public int solution(int n, int[][] q, int[] ans) {
        int m = ans.length;
        answer = 0;
        hints = new int[m];
        int password = 0;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < 5; j++){
                int num = 1 << (q[i][j] - 1);
                hints[i] += num;
            }
        }
        
        combine(0, 0, n, 0, ans);
        
        return answer;
    }
    
    public void combine(int start, int password, int n, int depth, int[] ans){
        if(depth == 5){
            for(int i = 0; i < hints.length; i++){
                int correctCount = Integer.bitCount(password & hints[i]);
                
                if(correctCount != ans[i]){
                    return;
                }
            }
            
            answer++;
            return;
        }
        
        for(int i = start; i < n; i++){
            password += 1 << i;
            combine(i + 1, password, n, depth + 1, ans);
            password -= 1 << i;
        }
    } 
}
