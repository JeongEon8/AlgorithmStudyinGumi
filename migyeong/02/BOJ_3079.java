import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        long[] times = new long[N];
        long max = 0;
        
        for (int i = 0; i < N; i++) {
            times[i] = Long.parseLong(br.readLine());
            max = Math.max(max, times[i]);
        }
        
        long left = 1, right = max * M, ans = right;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            long cnt = 0;
            for (long t : times) {
                cnt += mid / t;
                if (cnt >= M) break;
            }
            if (cnt >= M) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        System.out.println(ans);
    }
}
