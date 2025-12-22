import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] books = new int[M+1][N+1];

        int[][] dp = new int[M+1][N+1]; // 페이지수, 일 수

        for(int i = 1; i < M+1; i++) {
            st = new StringTokenizer(bf.readLine());
            books[i][1] = Integer.parseInt(st.nextToken());
            books[i][0] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < M+1; i++) {
            for(int j = 1; j < N+1; j++) {
                if(j < books[i][1]) dp[i][j] = dp[i-1][j];
                else dp[i][j] = Math.max(dp[i-1][j-books[i][1]]+books[i][0], dp[i-1][j]);
            }
        }

        System.out.println(dp[M][N]);
    }
}
