package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon2573 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] arr;
    static boolean[][] visited;
    static int N, M;

    // DFS로 연결된 빙산 탐색
    public static void dfs(int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < N && ny < M && arr[nx][ny] > 0 && !visited[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }

    // 빙산 녹이기
    public static void melt() {
        int[][] temp = new int[N][M];
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                if (arr[x][y] > 0) {
                    int seaCount = 0;
                    for (int i = 0; i < 4; i++) {
                        int nx = x + dx[i];
                        int ny = y + dy[i];
                        if (nx >= 0 && ny >= 0 && nx < N && ny < M && arr[nx][ny] == 0) {
                            seaCount++;
                        }
                    }
                    temp[x][y] = Math.max(0, arr[x][y] - seaCount);
                }
            }
        }
        arr = temp; // 한 번에 갱신
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] input = in.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            input = in.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        int year = 0;

        while (true) {
            int lend = 0; // 빙산 덩어리 수
            visited = new boolean[N][M];

            // 빙산 덩어리 수 계산
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < M; y++) {
                    if (arr[x][y] > 0 && !visited[x][y]) {
                        dfs(x, y);
                        lend++;
                    }
                }
            }

            if (lend >= 2) { // 두 덩어리 이상으로 분리된 경우
                System.out.println(year);
                break;
            } else if (lend == 0) { // 빙산이 모두 녹은 경우
                System.out.println(0);
                break;
            }

            melt(); // 빙산 녹이기
            year++;
        }
    }
}
