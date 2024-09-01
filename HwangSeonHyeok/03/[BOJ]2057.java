import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(in.readLine());
        if (n == 0) {
            System.out.println("NO");
            return;
        }
        long[] factorial = new long[20];
        factorial[0] = 1;
        for (int i = 1; i < 20; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        for (int i = 19; i >= 0; i--) {
            if (n >= factorial[i]) {
                n -= factorial[i];
            }
        }
        if (n == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

}