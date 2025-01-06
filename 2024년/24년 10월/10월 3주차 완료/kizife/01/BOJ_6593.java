import java.util.LinkedList;
import java.util.Queue; 
import java.util.Scanner;

public class BOJ_6593 {

    static int l, r, c;
    static int count;
    static char[][][] map;
    static boolean[][][] visit;
    static Queue<int[]> queue = new LinkedList<>();
    static int[] dx = { 1, 0, -1, 0, 0, 0 };
    static int[] dy = { 0, 1, 0, -1, 0, 0 };
    static int[] dz = { 0, 0, 0, 0, 1, -1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {

            l = sc.nextInt();
            r = sc.nextInt();
            c = sc.nextInt();

            if (l == 0 && r == 0 && c == 0)
                break;

            map = new char[l][r][c];
            visit = new boolean[l][r][c];

            for (int i = 0; i < l; i++) {
                sc.nextLine();
                for (int j = 0; j < r; j++) {
                    String line = sc.nextLine();
                    for (int k = 0; k < c; k++) {
                        map[i][j][k] = line.charAt(k);
                    }
                }
            }

            boolean exitFounded = false;
            count = 0;

            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    for (int k = 0; k < c; k++) {
                        if (map[i][j][k] == 'S') {
                            count = bfs(i, j, k);
                        }
                    }
                }
            }

            if (count != -1)
                System.out.println("Escaped in " + count + " minute(s).");
            else if (count == -1)
                System.out.println("Trapped!");

        }
    }

    private static int bfs(int i, int j, int k) {
        queue.clear();

        visit[i][j][k] = true;
        queue.add(new int[] { i, j, k, 0 }); // 시작 좌표 추가

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int s = 0; s < size; s++) {

                int[] now = queue.poll();

                int x = now[0];
                int y = now[1];
                int z = now[2];
                int dist = now[3];

                if (map[x][y][z] == 'E') {
                    return dist;
                }

                for (int num = 0; num < 6; num++) {
                    int nx = x + dx[num];
                    int ny = y + dy[num];
                    int nz = z + dz[num];

                    if (nx >= 0 && ny >= 0 && nz >= 0 && nx < l && ny < r && nz < c && !visit[nx][ny][nz]) {
                        if (map[nx][ny][nz] != '#') {
                            queue.add(new int[] { nx, ny, nz, dist + 1 });
                            visit[nx][ny][nz] = true;
                        }
                    }
                }
            }

        }

        return -1;

    }

}
