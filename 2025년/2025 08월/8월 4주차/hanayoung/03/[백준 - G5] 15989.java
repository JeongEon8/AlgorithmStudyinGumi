import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());

        int[] tc = new int[N+1];
        int max = 0;
        for(int i = 1; i < N+1; i++) {
            st = new StringTokenizer(bf.readLine());
            tc[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, tc[i]);
        }

        int[][] dp = new int[max+1][4];
        
        dp[1][1] = dp[2][1] = dp[2][2] = dp[3][1] = dp[3][2] = dp[3][3] = 1;

        for(int i = 4; i < max+1; i++) {
            dp[i][1] = dp[i-1][1];
            dp[i][2] = dp[i-2][1] + dp[i-2][2];
            dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
        }

        for(int i = 1; i < N+1; i++) {
            sb.append(dp[tc[i]][1]+dp[tc[i]][2]+dp[tc[i]][3]).append("\n");
        }

        System.out.println(sb);  
    }
}
