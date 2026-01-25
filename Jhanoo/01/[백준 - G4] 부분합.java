import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] a = new int[N];
        st = new StringTokenizer(br.readLine());
        a[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0;
        int r = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        while (true) {
            if (sum >= S) {
                ans = Math.min(ans, r - l);
                sum -= a[l++];
            } else {
                if (r == N)
                    break;
                sum += a[r++];
            }
        }
        
        System.out.println(ans == Integer.MAX_VALUE ? 0 : ans);
    }
}