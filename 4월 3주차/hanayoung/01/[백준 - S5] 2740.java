import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] matrixA = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j = 0; j < M; j++) {
                matrixA[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(bf.readLine());
        Integer.valueOf(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] matrixB = new int[M][K];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j = 0; j < K; j++) {
                matrixB[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < K; j++) {
                int sum = 0;
                for(int l = 0; l < M; l++) {
                    sum += matrixA[i][l] * matrixB[l][j];
                }
                sb.append(sum).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }
}
