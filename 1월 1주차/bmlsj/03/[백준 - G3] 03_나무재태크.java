
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int N, M, K;
    static int[][] A;
    static int[][] nutrients;
    static List<Integer>[][] trees;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        K = Integer.parseInt(split[2]);

        trees = new ArrayList[N][N]; // 나무 나이들
        nutrients = new int[N][N]; // 양분
        A = new int[N][N];
        for (int i = 0; i < N; i++) { // 추가될 양분 A[r][c]
            split = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(split[j]);
            }
        }
        // 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                trees[i][j] = new ArrayList<>();
                nutrients[i][j] = 5;
            }
        }

        for (int i = 0; i < M; i++) {
            split = br.readLine().split(" ");
            int r = Integer.parseInt(split[0]) - 1;
            int c = Integer.parseInt(split[1]) - 1;
            int age = Integer.parseInt(split[2]);
            trees[r][c].add(age);
        }

        while (K > 0) {
            K--;
            spring(N);
            fall(N);
            winter(N);
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer += (trees[i][j].size());
            }
        }
        System.out.println(answer);
    }

    static void spring(int N) {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                Collections.sort(trees[i][j]);
                List<Integer> alive = new ArrayList<>();
                int dead = 0;
                for (int age : trees[i][j]) {
                    if (nutrients[i][j] >= age) {
                        nutrients[i][j] -= age;
                        alive.add(age + 1);
                    } else {
                        dead += age / 2;
                    }
                }

                trees[i][j] = alive;
                nutrients[i][j] += dead;
            }
        }
    }

    static void fall(int N) {

        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        // 나무가 있고, 나이가 5의 배수
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int age : trees[i][j]) {
                    if (age % 5 == 0) {
                        for (int d = 0; d < 8; d++) {
                            int nx = i + dx[d];
                            int ny = j + dy[d];

                            if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                                continue;
                            }
                            trees[nx][ny].add(1);
                        }
                    }
                }
            }
        }
    }

    static void winter(int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                nutrients[i][j] += A[i][j];
            }
        }
    }

}
