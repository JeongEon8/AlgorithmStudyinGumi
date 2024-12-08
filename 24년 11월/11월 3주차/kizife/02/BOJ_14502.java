import java.util.Scanner;

public class Main {

    static int n, m;
    static int[][] arr;
    static boolean[][] visit;
    static int maxArea;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        maxArea = 0;
        makeWalls(0);
        System.out.println(maxArea);
    }

    // 벽을 3개 설치하는 모든 경우
    private static void makeWalls(int count) {
        if (count == 3) {
            safeArea(); // 안전 영역 계산
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) { // 빈 칸에 벽 설치
                    arr[i][j] = 1; // 벽 설치
                    makeWalls(count + 1);
                    arr[i][j] = 0; //벽 제거
                }
            }
        }
    }

    private static void safeArea() {
        visit = new boolean[n][m];
        int currentArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0 && !visit[i][j]) {
                    int area = dfs(i, j);
                    if(area != -1) {
                        currentArea += area;
                    }
                }
            }
        }

        maxArea = Math.max(maxArea, currentArea);
    }

    private static int dfs(int x, int y) {
        visit[x][y] = true;
        int area = 1;
        boolean nearByVirus = false;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m ) {
                if(arr[nx][ny] == 2) {
                    nearByVirus = true;
                } else if (!visit[nx][ny] && arr[nx][ny] == 0) {
                    int result = dfs(nx, ny);
                    if (result == -1) {
                        nearByVirus= true;
                    } else{
                        area += result;
                    }
                }
            }
        }

        return nearByVirus ? -1 : area;
    }
}
