import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] list = new int[n + 1][n + 1];
        int[][] shortCut = new int[n + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (list[a][b] > c || list[a][b] == 0) {
                list[a][b] = c;
                shortCut[a][b] = b;
            }

        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                if (i == k || list[i][k] == 0) continue;
                for (int j = 1; j <= n; j++) {
                    if (j == i || k == j || list[k][j] == 0) continue;
                    if (list[i][j] == 0 || list[i][j] > list[i][k] + list[k][j]) {
                        list[i][j] = list[i][k] + list[k][j];
                        shortCut[i][j] = shortCut[i][k];
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sb.append(list[i][j]);
                sb.append(' ');
            }
            sb.append('\n');
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int i1 = list[i][j];

                if (i1 != 0) {
                    int count = 0;
                    int a = i;
                    int b = j;
                    List<Integer> tmp = new ArrayList<>();
                    do {
                        count++;
                        tmp.add(a);
                        a = shortCut[a][b];
                    } while (a != 0);

                    sb.append(count);
                    sb.append(' ');
                    for (Integer integer : tmp) {
                        sb.append(integer);
                        sb.append(' ');
                    }
                } else {
                    sb.append(i1);
                }
                sb.append('\n');
            }
        }

        System.out.println(sb);
    }
}
