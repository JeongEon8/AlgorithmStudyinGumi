class Solution {
    public int[] solution(int[] sequence, int k) {
        int left = 0;
        int right = 0;
        int sum = sequence[0];
        
        int n = sequence.length - 1;
        int[] answer = {0, n};
        
        while (left <= right) {
            int len = answer[1] - answer[0] + 1;
            int curLen = right - left + 1;
            
            if (sum < k) {
                if (right == n) break;
                
                sum += sequence[++right];
            }
            
            else if (sum > k) {
                sum -= sequence[left++];
            }
            
            else if (sum == k) {
                if (curLen < len) {
                    answer[0] = left;
                    answer[1] = right;
                }
                
                if (right == n) 
                    sum -= sequence[left++];
                else 
                    sum += sequence[++right];
            }
        }
        
        return answer;
    }
}
