import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static long[] stones;
    public static long power(int i, int j){
        return (j-i)*(1+Math.abs(stones[i]-stones[j]));
    }
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        long[] dp = new long[n+1];
        stones = new long[n+1];
        String[] split = in.readLine().split(" ");
        for(int i = 1; i<=n;i++){
            stones[i] = Long.parseLong(split[i-1]);
            dp[i]=50000000000L;
        }
        dp[1] = 0;
        for(int i = 2; i<=n;i++){
            for(int j = 1;j<i;j++){
                dp[i] = Math.min(dp[i],Math.max(dp[j],power(j,i)));
            }
        }
        System.out.println(dp[n]);


    }
}