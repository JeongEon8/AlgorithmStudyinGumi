import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] split = in.readLine().split(" ");
        int x = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);
        long[] leftCnt = new long[k + 1];
        long[] rightCnt = new long[k + 1];
        split = in.readLine().split(" ");
        for (int i = 0; i < x; i++) {
            leftCnt[Integer.parseInt(split[i])]++;
        }
        for (int i = x; i < 2 * x; i++) {
            rightCnt[Integer.parseInt(split[i])]++;
        }
        long ans = 0;
        for (int i = 1; i <= k; i++) {
            ans += leftCnt[i] * (x - rightCnt[i]);
        }
        System.out.println(ans);
    }
}