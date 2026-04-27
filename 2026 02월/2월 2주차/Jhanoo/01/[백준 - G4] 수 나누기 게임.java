import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] a = new int[N];
        boolean[] present = new boolean[1_000_001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            present[a[i]] = true;
            max = Math.max(max, a[i]);
        }

        int[] score = new int[max + 1];

        for (int x : a) {
            for (int m = x * 2; m <= max; m += x) {
                if (present[m]) {
                    score[m]--;
                    score[x]++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(score[a[i]]);
            if (i + 1 < N) sb.append(' ');
        }
        System.out.println(sb);
    }
}