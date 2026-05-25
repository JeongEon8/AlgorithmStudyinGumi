class Solution {
    public int[] solution(int n, long left, long right) {
        int N = (int) (right - left + 1);
        int[] answer = new int[N];
        
        for(int i = 0; i < N; i++){
            int row = (int) ((left + i) / n);
            int col = (int) ((left + i) % n);
            
            answer[i] = Math.max(row, col) + 1;
        }
        
        return answer;
    }
}
