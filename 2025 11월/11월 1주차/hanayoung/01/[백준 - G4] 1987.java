import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int answer = 0;
    static int R;
    static int C;
    static int[][] maps;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        boolean[] alpha = new boolean[26];

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        maps = new int[R][C];

        for(int i = 0; i < R; i++) {
            st = new StringTokenizer(bf.readLine());
            String str = st.nextToken();
            for(int j = 0; j < C; j++) {
                maps[i][j] = str.charAt(j) - 'A';
            }
        }

        alpha[maps[0][0]] = true;
        recur(alpha, 0, 0, 1);
        System.out.println(answer);
    }
    static void recur(boolean[] alpha, int x, int y, int length) {
        if(length > answer) answer = length;
        if(x < 0 || x >= R || y < 0 || y >= C) return;
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        for(int i = 0 ; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;

            if(alpha[maps[nx][ny]] == false) {
                alpha[maps[nx][ny]] = true;
                recur(alpha, nx, ny, length+1);
                alpha[maps[nx][ny]] = false;
            }
        }
    }
}
