

class Solution {
    
    static final int MOD = 1234567;
    
    public long solution(int n) {
        // a1=1C1, a2=2C2+1C1, a3=3C3+2C1, a4=4C4+3C1+2C2, a5=5C5+4C1+3C2, ..., an=nCn+n-1C1+n-2C2+...
        // 이를 정리하면 피보나치의 형태를 띄게 된다.
        long[] fibo = new long[2001];
        fibo[1] = 1;
        fibo[2] = 2;
        
        for (int i = 3; i <= n; i++) {
            fibo[i] = (fibo[i - 1] + fibo[i - 2]) % MOD;
        }
        
        return fibo[n];
    }
}
