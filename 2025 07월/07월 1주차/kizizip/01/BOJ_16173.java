import java.util.Scanner;

public class Main {
    static int n;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        if (dfs(0, 0)) {
            System.out.println("HaruHaru");
        } else {
            System.out.println("Hing");
        }


    }

    static boolean dfs(int x, int y) {
        if (map[x][y] == -1) {
            return true;
        }

        if (visited[x][y]) return false;

        visited[x][y] = true;
        int jump = map[x][y];

        // 오른쪽으로 점프
        if (y+jump < n && dfs(x, y+jump)) {
            return true;
        }

        //아래쪽으로 점프
        if (x+jump < n && dfs(x+jump, y)) {
            return true;
        }

        return false;
    }
}
