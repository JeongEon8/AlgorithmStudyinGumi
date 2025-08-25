import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Object[] arr = new Object[N+1];
        int[][] dp = new int[N+1][K+1];

        for(int i = 1; i < N+1; i++) {
            st = new StringTokenizer(bf.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken()); 
            arr[i] = new Object(w, v);
        }

        for(int i = 1; i < N+1; i++) {
            for(int j = 1; j < K+1; j++) {
                if(j < arr[i].weight) { 
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-arr[i].weight]+arr[i].value);
                }
            }
        }

        System.out.println(dp[N][K]);

    }

    static class Object {
        int weight;
        int value;

        public Object(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
}
