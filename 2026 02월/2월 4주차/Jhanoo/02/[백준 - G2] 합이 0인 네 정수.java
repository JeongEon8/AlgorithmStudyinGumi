import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] A = new int[n];
        int[] B = new int[n];
        int[] C = new int[n];
        int[] D = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        int size = n * n;
        int[] AB = new int[size];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                AB[idx++] = A[i] + B[j];
            }
        }

        Arrays.sort(AB);

        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int cdSum = -(C[i] + D[j]);
                ans += upperBound(AB, cdSum) - lowerBound(AB, cdSum);
            }
        }

        System.out.println(ans);

    }

    static int upperBound(int[] ab, int cdSum) {
        int l = 0, r = ab.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (ab[m] > cdSum) r = m;
            else l = m + 1;
        }
        return l;
    }

    static int lowerBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (arr[m] >= target) r = m;
            else l = m + 1;
        }
        return l;
    }

}