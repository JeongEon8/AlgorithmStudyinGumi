import java.io.*;
import java.util.*;

public class Main {

    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] scoville = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.sort(scoville);

        long[] pow2 = new long[N];
        pow2[0] = 1;
        for (int i = 1; i < N; i++) {
            pow2[i] = (pow2[i - 1] * 2) % MOD;
        }

        long sum = 0;
        for (int i = 0; i < N; i++) {
            long maxCount = pow2[i];
            long minCount = pow2[N - 1 - i];
            long contribution = (maxCount - minCount + MOD) % MOD;

            // (a[r] - a[l]) * 2^(r-l-1) = a[i] * (2^i - 2^(N-1-i))
            sum = (sum + scoville[i] * contribution) % MOD;
        }

        System.out.println(sum);
    }

}