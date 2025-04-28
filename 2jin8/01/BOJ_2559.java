import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2559 {

    static int N, K, INF = -10_000_000;
    static int[] temperatures;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 전체 날짜 수
        K = Integer.parseInt(st.nextToken()); // 연속적인 날짜 수
        temperatures = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            temperatures[i] = temperatures[i - 1] + Integer.parseInt(st.nextToken());
        }

        int maxTemperatures = INF;
        for (int i = K; i <= N; i++) {
            maxTemperatures = Math.max(maxTemperatures, temperatures[i] - temperatures[i - K]);
        }
        System.out.println(maxTemperatures);
    }
}
