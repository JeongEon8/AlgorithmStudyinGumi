import java.util.Arrays;

class Solution {

    int[][] grid;

    int n;
    int m;
    
    int lineCount;

    int[][] line = new int[8][4];

    final int R = 0;
    final int D = 1;
    final int L = 2;
    final int U = 3;

    int[] dr = {0, 1, 0, -1};
    int[] dc = {1, 0, -1, 0};

    int[][] set;

    boolean[][][] check;

    int answer = 0;


    public int solution(int[][] grid) {

        this.grid = grid;

        n = grid.length;
        m = grid[0].length;

        init();

        set = new int[n][m];

        check = new boolean[n][m][2];

        lineCount = 0;

        for (int r = 0; r < n; r++) {

            for (int c = 0; c < m; c++) {

                if (grid[r][c] == 3) {
                    
                    lineCount += 2;

                } else if (grid[r][c] > 0) {

                    lineCount++;
                }
            }
        }

        dfs(0, 0, R, 0);

        return answer;
    }


    public void dfs(int r, int c, int dir, int count) {

        if (r < 0 || r >= n ||
            c < 0 || c >= m) {

            return;
        }

        if (grid[r][c] == -1) {
            return;
        }
        
        if (grid[r][c] > 0) {

            int track = grid[r][c];

            int nextDir = line[track][dir];

            if (nextDir == -1) {
                return;
            }

            int type = getType(track, dir);

            if (check[r][c][type]) {
                return;
            }

            check[r][c][type] = true;

            count++;

            if (r == n - 1 && c == m - 1) {

                if (count == lineCount) {
                    answer++;
                }

                check[r][c][type] = false;

                return;
            }

            int nr = r + dr[nextDir];
            int nc = c + dc[nextDir];

            dfs(
                nr,
                nc,
                nextDir,
                count
            );

            check[r][c][type] = false;

            return;
        }

        if (set[r][c] != 0) {

            int track = set[r][c];

            int nextDir = line[track][dir];

            if (nextDir == -1) {
                return;
            }


            int type = getType(track, dir);

            if (check[r][c][type]) {
                return;
            }

            check[r][c][type] = true;

            int nr = r + dr[nextDir];
            int nc = c + dc[nextDir];


            dfs(
                nr,
                nc,
                nextDir,
                count
            );

            check[r][c][type] = false;

            return;
        }

        for (int track = 3; track <= 7; track++) {

            int nextDir = line[track][dir];

            if (nextDir == -1) {
                continue;
            }

            set[r][c] = track;

            int type = getType(track, dir);

            check[r][c][type] = true;

            int nr = r + dr[nextDir];
            int nc = c + dc[nextDir];

            dfs(
                nr,
                nc,
                nextDir,
                count
            );


            check[r][c][type] = false;

            set[r][c] = 0;
        }
    }

    public int getType(int track, int dir) {

        if (track != 3) {
            return 0;
        }

        if (dir == R || dir == L) {
            return 0;
        }

        return 1;
    }

    public void init() {

        for (int i = 0; i < 8; i++) {
            Arrays.fill(line[i], -1);
        }

        line[1][R] = R;
        line[1][L] = L;


        line[2][D] = D;
        line[2][U] = U;



        line[3][R] = R;
        line[3][D] = D;
        line[3][L] = L;
        line[3][U] = U;


        line[4][R] = U;
        line[4][D] = L;

        line[5][D] = R;
        line[5][L] = U;


        line[6][U] = R;
        line[6][L] = D;


       

        line[7][R] = D;
        line[7][U] = L;
    }
}
