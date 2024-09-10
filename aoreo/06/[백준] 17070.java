import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    static int[] dx = {0,1,1};
    static int[] dy = {1,0,1}; 
    static boolean[][] visited;
    static int[][] maps;
    static int N;
    static int answer = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());

        maps = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited[0][0] = true;
        visited[0][1] = true;

        dfs(0,1,0); // 0 - 가로, 1 - 세로, 2 - 대각선

        System.out.println(answer);
    }

    static void dfs(int x, int y, int status) {
        if(x == N -1 && y == N-1) {
            answer += 1;
            return;
        }
        for (int i = 0; i < 3; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

            if(status == 0 && i == 1) continue;
            if(status == 1 && i == 0) continue; 

            if(maps[nx][ny] == 0 && visited[nx][ny] == false) {
                if(i == 2){
                    if(maps[nx-1][ny] == 0 && maps[nx][ny-1] == 0){
                        visited[nx][ny] = true;
                        dfs(nx, ny, i);
                        visited[nx][ny] = false;
                    }
                }else{
                    visited[nx][ny] = true;
                    dfs(nx, ny, i);
                    visited[nx][ny] = false;
                }
            }

        }
    }
}
