import java.util.*;
import java.io.*;

public class Main {

    static long k = 9;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Integer.parseInt(st.nextToken());
        long m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        System.out.println(newPow(n, m) % k);

    }

    private static long newPow(long n, long m) {
        if (m == 1) return n;
        long temp = newPow(n, m / 2);

        if (m % 2 == 1) {
            return (temp * temp % k) * n % k;
        }
        return temp * temp % k;
    }

}
