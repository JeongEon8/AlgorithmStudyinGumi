class Solution {
    static int N;
    static int[][] Q;
    static int[] ANS;
    
    static int answer = 0;
    
    public int solution(int n, int[][] q, int[] ans) {
        N = n;
        Q = q;
        ANS = ans;
        
        dfs(new int[5], 1, 0);
    
        return answer;
    }
    
    public void dfs(int[] selected, int start, int depth) {
        if (depth == 5) {
            if (isValid(selected)) 
                answer++;
            
            return;
        }
        
        for (int num = start; num <= N; num++) {
            selected[depth] = num;
            dfs(selected, num + 1, depth + 1);
        }
    }

    public boolean isValid(int[] selected) {
        for (int i = 0; i < Q.length; i++) {
            int match = 0;

            for (int x : selected) {
                for (int y : Q[i]) {
                    if (x == y) {
                        match++;
                        break;
                    }
                }
            }

            if (match != ANS[i]) {
                return false;
            }
        }
        
        return true;
    }
}
