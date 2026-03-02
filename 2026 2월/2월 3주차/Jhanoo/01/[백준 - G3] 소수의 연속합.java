import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= N; i++) {
            if (!isPrime[i]) continue;

            for (int j = i * i; j <= N; j += i) {
                isPrime[j] = false;
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) primes.add(i);
        }

        int size = primes.size();
        int l = 0;
        int r = 0;
        int sum = 0;
        int cnt = 0;
        while (l <= r && r < size) {
            sum += primes.get(r);

            while (sum >= N) {
                if (sum == N) {
                    cnt++;
                }

                sum -= primes.get(l);
                l++;
            }
            r++;
        }

        System.out.println(cnt);
    }
}