class Solution {
    public int solution(int n) {
        int minNum = 0;
        boolean findMinBit = false;
        int k = 1;
        int cnt = 0;
        
        while(true) {
            if (findMinBit && (n & k) == 0)
                break;
                
            if ((n & k) != 0) {
                if (!findMinBit) {
                    findMinBit = true;
                    minNum = k;
                }
                cnt++;
            }
            
            k <<= 1;
        }
        
        int answer = n + minNum;
        cnt--;
        
        k = 1;
        while (cnt > 0) {
            if ((answer & k) == 0) {
                cnt--;
                answer += k;
            }
            
            k <<= 1;
        }
        
        return answer;
    }
}