import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = (int) Math.pow(2, N);
        int answer = 0;
        for (int i = 0; i < N; i++) {
            if (k / 2 > n && k / 2 > m) {//2사분면
                answer += 0;
            } else if (k / 2 <= n && k / 2 > m) {//3사분면
                answer += (k / 2) * (k / 2) * 2;
                n -= k / 2;
            } else if (k / 2 > n && k / 2 <= m) {//1사분면
                answer += (k / 2) * (k / 2);
                m -= k / 2;
            } else if (k / 2 <= n && k / 2 <= m) {//4사분면
                answer += (k / 2) * (k / 2) * 3;
                n -= k / 2;
                m -= k / 2;
            }
            k /= 2;

        }
        System.out.println(answer);
    }
}
