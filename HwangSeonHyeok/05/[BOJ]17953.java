import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] split = in.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        int[][] arr = new int[m][n];
        int[][] dp = new int[n][m];
        for(int i = 0; i<m;i++){
            split = in.readLine().split(" ");
            for(int j = 0;j<n;j++) {
                arr[i][j] = Integer.parseInt(split[j]);
            }
            dp[0][i] = arr[i][0];

        }
        for(int i = 1;i<n;i++){
             for(int j = 0;j<m;j++){
                 for(int k = 0; k<m;k++){
                     if(j==k){
                         dp[i][j] = Math.max(dp[i-1][k]+(arr[j][i]/2),dp[i][j]);
                     }else {
                         dp[i][j] = Math.max(dp[i-1][k]+arr[j][i],dp[i][j]);
                     }
                 }
             }
        }
        int ans = 0;
        for(int i = 0; i<m;i++){
            ans = Math.max(ans,dp[n-1][i]);
        }
        System.out.println(ans);

    }
}