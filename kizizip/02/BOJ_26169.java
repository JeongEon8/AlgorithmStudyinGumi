import java.util.Scanner;

public class Main {
    static int[][] map = new int[5][5];
    static boolean[][] visited = new boolean[5][5];
    static int r, c;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        r = sc.nextInt();
        c = sc.nextInt();

        int startApple;
        if (map[r][c] == 1) {
            startApple = 1;
        } else {
            startApple = 0;
        }
        visited[r][c] = true;

        if (dfs(r, c, 0, startApple)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }



    }

    static boolean dfs(int x, int y, int count, int apples) {
        if (apples>=2) return true;
        if (count>=3) return false;

        for (int i = 0; i < 4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];

            if (nx<0 || nx>=5 || ny<0 || ny>=5) continue;
            if (visited[nx][ny] || map[nx][ny] == -1) continue; 

            visited[nx][ny]= true;

            int nextApples = apples;
            if (map[nx][ny] ==1) nextApples++;

            if (dfs(nx, ny, count+1, nextApples)) return true;

            visited[nx][ny] = false; //백트래킹: 방문처리 해제
        }
        return false;
    }
}
