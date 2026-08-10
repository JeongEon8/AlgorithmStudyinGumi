class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
            
        for (int i=1; i<=Math.max(n, m); i++) {
            if (n%i==0 && m%i==0) {
                answer[0] = i;
            }
        }
        
        boolean tf = false;
        int rhq = 1;
        while (!tf) {
            int num = Math.max(n,m)*rhq;
            if (num%Math.min(n,m)==0) {
                answer[1] = num;
                tf=true;
            } else rhq++;
        }
        
        return answer;
    }
}
