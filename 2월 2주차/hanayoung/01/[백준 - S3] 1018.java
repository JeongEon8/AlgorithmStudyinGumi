import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[][] maps = new boolean[N][M]; // false가 흑, true가 백

        for(int i = 0; i < N; i++) {
            String str = bf.readLine();
            for(int j = 0; j < M; j++) {
                if(str.charAt(j) == 'B') maps[i][j] = false;
                else maps[i][j] = true;
            }
        }

        int answer = Integer.MAX_VALUE;

        boolean[][] copy = new boolean[N][M];

        for(int i = 0; i <= N-8; i++) {
            for(int j = 0; j <= M-8; j++) {
                int idx = 0;
                while(idx < 2) {
                    int diff = 0;

                    for(int l = 0; l < N; l++) {
                        copy[l] = maps[l].clone();
                    }
                    boolean prev;

                    if(idx == 0) {
                        prev = false;
                        if(prev != maps[i][j]) {
                            copy[i][j] = prev;
                            diff++;
                        }
                    }
                    else {
                        prev = true;
                        if(prev != maps[i][j]) {
                            copy[i][j] = prev;
                            diff++;
                        }
                    }

                    for(int l = i; l < i+8; l++) {
                        for(int k = j; k < j+8; k++) {
                            if(l == i && k == j) continue;
                            if(prev == copy[l][k]) {
                                diff++;
                                prev = !copy[l][k];
                                copy[l][k] = !copy[l][k];
                            }
                            else prev = copy[l][k];
                        }
                        prev = copy[l][j];
                    }
                    answer = Math.min(answer, diff);
                    idx++;
                }
            }
        }

        System.out.println(answer);
    }
}
