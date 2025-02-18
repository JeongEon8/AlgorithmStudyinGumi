import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[][] mars, dp;
    static int n,m;

    static void solve(){
        dp[1][1] = mars[1][1];
        for(int i = 1; i<=n;i++){
            for(int j = 1;j<=m;j++){
                dp[i][j] = Math.max(dp[i][j],Math.max(dp[i-1][j]+mars[i][j],dp[i][j-1]+mars[i][j]));
            }
            if(i==1||i==n) continue;
            int lineDP = dp[i-1][m]+mars[i][m];
            for(int j=m-1;j>=1;j--){
                lineDP = Math.max(dp[i-1][j]+mars[i][j],lineDP+mars[i][j]);
                if(dp[i][j]<lineDP){
                    dp[i][j] = lineDP;
                }
            }

        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader in =  new BufferedReader(new InputStreamReader(System.in));
        String[] split = in.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);
        mars = new int[n+1][m+1];
        dp = new int[n+1][m+1];
        for(int i = 1; i<=n;i++){
            split = in.readLine().split(" ");
            for(int j = 1; j<=m;j++){
                mars[i][j] = Integer.parseInt(split[j-1]);
            }
        }
        for(int i = 0;i<=n;i++){
            for(int j =0; j<=m;j++){
                dp[i][j] = (int) -1e9;
            }
        }
        solve();
        System.out.println(dp[n][m]);
    }
}