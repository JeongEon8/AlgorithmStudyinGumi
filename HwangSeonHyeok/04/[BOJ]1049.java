import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] split = in.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        int minPackage = Integer.MAX_VALUE;
        int minEach = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            split = in.readLine().split(" ");
            int p = Integer.parseInt(split[0]);
            int e = Integer.parseInt(split[1]);
            if (minPackage > p) {
                minPackage = p;
            }
            if (minEach > e) {
                minEach = e;
            }
        }
        int ans = Integer.MAX_VALUE;
        if (ans > minEach * n) {
            ans = minEach * n;
        }
        if (ans > (n / 6) * minPackage + (n % 6) * minEach) {
            ans = (n / 6) * minPackage + (n % 6) * minEach;
        }
        if (ans > (n / 6 + 1) * minPackage) {
            ans = (n / 6 + 1) * minPackage;
        }
        System.out.println(ans);

    }
}