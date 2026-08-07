class Solution {
    public int solution(int[] players, int m, int k) {
        int[] servers = new int[24 + k];
        int answer = 0;
        
        for (int i = 0; i < 24; i++) {
            if (i > 0) {
                servers[i] += servers[i - 1];
            }
            
            int needServerCnt = players[i] / m;
            if (needServerCnt > servers[i]) {
                int newServerCnt = needServerCnt - servers[i];
                servers[i] += newServerCnt;
                servers[i + k] -= newServerCnt;
                answer += newServerCnt;
            }
        }
        
        return answer;
    }
}
