class Solution {
    public int[] solution(int n, long left, long right) {
        
        int[] answer = new int[(int)(right - left + 1)];
        int idx = 0;
        
        for(long k = left; k <= right; k++) {
             
            long i = k / n;
            long j = k % n;
            
            if (j < i) {
                answer[idx++] = (int) i + 1;
            } else {
                answer[idx++] = (int) j + 1;
            }
        }
        
        return answer;
    }
}