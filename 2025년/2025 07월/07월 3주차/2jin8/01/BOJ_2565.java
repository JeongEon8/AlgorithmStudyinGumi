import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2565 {

    static int N, INF = 1_000_000_000;
    static int[] arr, dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        arr = new int[501]; // 번호는 최대 500
        dp = new int[501];
        int maxNum = 0;
        Arrays.fill(arr, INF);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a] = b; // a와 연결된 b 전봇대의 번호
            maxNum = Math.max(a, maxNum);
        }

        // 최장 증가 수열 구하기
        int maxConnect = 0; // 겹치지 않게 연결하는 전깃줄의 수
        dp[1] = 1;
        for (int i = 2; i <= maxNum; i++) {
            if (arr[i] == INF) continue;

            dp[i] = 1; // 자기 자신
            for (int j = 1; j < i; j++) {
                // 현재 번호보다 작은 번호가 존재하면 갱신
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxConnect = Math.max(maxConnect, dp[i]);
        }
        System.out.println(N - maxConnect);
    }
}
