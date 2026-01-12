import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] pos = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            pos[i][0] = Integer.parseInt(st.nextToken());
            pos[i][1] = Integer.parseInt(st.nextToken());
        }

        // 신발끈 공식
        double area = 0;
        for (int i = 0; i < n; i++) {
            area += (double) pos[i][0] * pos[(i + 1) % n][1];
            area -= (double) pos[(i + 1) % n][0] * pos[i][1];
        }
        area /= 2;

        System.out.printf("%.1f\n", Math.abs(area));
    }
}