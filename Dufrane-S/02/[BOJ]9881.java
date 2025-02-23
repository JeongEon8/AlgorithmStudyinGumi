import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] counts = new int[101];
        int N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            counts[n] = counts[n] + 1;
        }
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i < 101 - 17; i++) {
            int tmp = 0;
            for (int j = 0; j < i; j++) {
                if (counts[j] != 0) tmp += (i - j) * (i - j) * counts[j];
            }
            for (int k = 100; k > i + 17; k--) {
                if (counts[k] != 0) tmp += (k - (i + 17)) * (k - (i + 17)) * counts[k];
            }
            if (answer > tmp) answer = tmp;
        }
        System.out.println(answer);
    }
}
