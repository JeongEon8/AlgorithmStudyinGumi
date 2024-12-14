import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int edge = Integer.parseInt(br.readLine());
        int line = Integer.parseInt(br.readLine());
        int[][] list = new int[edge][edge];
        for (int i = 0; i < edge; i++) {
            for (int j = 0; j < edge; j++) {
                list[i][j] = Integer.MAX_VALUE;
            }
        }
        StringTokenizer st;
        for (int i = 0; i < line; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            a--;
            b--;
            if (list[a][b] > c) {
                list[a][b] = c;
            }
        }

        for (int j = 0; j < edge; j++) {
            for (int i = 0; i < edge; i++) {
                if (i == j || list[i][j] == Integer.MAX_VALUE) continue;
                for (int k = 0; k < edge; k++) {
                    if (i == k || j == k || list[j][k] == Integer.MAX_VALUE)
                        continue;
                    if (list[i][j] + list[j][k] < list[i][k]) {
                        list[i][k] = list[i][j] + list[j][k];
                    }
                }
            }
        }
        for (int f = 0; f < edge; f++) {
            for (int d = 0; d < edge; d++) {
                if (list[f][d] == Integer.MAX_VALUE) {
                    sb.append(0);
                } else {
                    sb.append(list[f][d]);
                }
                sb.append(' ');
            }
            sb.append('\n');
        }
        sb.append('\n');
        System.out.println(sb);
    }
}
