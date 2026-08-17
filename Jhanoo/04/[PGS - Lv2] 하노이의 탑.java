class Solution {
    
    static int idx = 0;
    static int[][] answer;
    
    public int[][] solution(int n) {
        answer = new int[(1 << n) - 1][2];
        
        hanoi(n, 1, 3, 2);
        
        return answer;
    }
    
    public static void hanoi(int n, int from, int to, int via) {
        if (n == 1) {
            answer[idx++] = new int[]{from, to};
            return;
        }

        hanoi(n - 1, from, via, to);

        answer[idx++] = new int[]{from, to};

        hanoi(n - 1, via, to, from);
    }
}
