import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] a = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(a);

        if (a[N - 1] < 0) {
            System.out.println(a[N - 3] + " " + a[N - 2] + " " + a[N - 1]);
            return;
        } else if (a[0] > 0) {
            System.out.println(a[0] + " " + a[1] + " " + a[2]);
            return;
        }

        long minAbs = Long.MAX_VALUE;
        int n1 = -1, n2 = -1, n3 = -1;
        for (int i = 0; i < N - 2; i++) {
            int l = i + 1;
            int r = N - 1;

            while (l < r) {
                long sum = a[i] + a[l] + a[r];
                long sumAbs = Math.abs(sum);


                if (sumAbs < minAbs) {
                    minAbs = sumAbs;
                    n1 = i;
                    n2 = l;
                    n3 = r;
                }

                if (sum > 0) r--;
                if (sum < 0) l++;
                if (sum == 0) {
                    System.out.println(a[i] + " " + a[l] + " " + a[r]);
                    return;
                }
            }
        }

        System.out.println(a[n1] + " " + a[n2] + " " + a[n3]);
    }
}