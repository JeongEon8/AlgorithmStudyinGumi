class Solution {
    public int solution(int[] arr) {
        int[] cnt = new int[101];
        
        for (int num : arr) {
            for (int i = 2; num > 1; i++) {
                if (num % i != 0) continue;
                
                int mulCnt = 0;
                while (num % i == 0) {
                    num /= i;
                    mulCnt++;
                }
                cnt[i] = Math.max(cnt[i], mulCnt);
            }
        }
        
        int answer = 1;
        for (int i = 2; i < 101; i++) {
            if (cnt[i] == 0) continue;
            answer *= Math.pow(i, cnt[i]);
        }
        
        return answer;
    }
}
