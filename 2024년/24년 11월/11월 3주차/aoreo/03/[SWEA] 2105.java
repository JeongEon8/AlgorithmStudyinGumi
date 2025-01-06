import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    static int N;
    static Point start;
    static int[][] maps;
    static int answer;
    static boolean[][][][] visited;
    static boolean[] ate;
    static int[] dx = {-1, -1, 1, 1}; // 상좌, 상우, 하우, 하좌
    static int[] dy = {-1, 1, 1, -1};
 
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
 
        int T = Integer.parseInt(st.nextToken());
 
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
 
            maps = new int[N][N];
 
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < N; j++) {
                    maps[i][j] = Integer.parseInt(st.nextToken())-1;
                }
            }
 
            answer = 0;
 
            for (int i = 0; i < N-2; i++) {
                for (int j = 1; j < N-1; j++) {
                    ate = new boolean[100];
                    start = new Point(i, j);
                    visited = new boolean[N][N][4][5];
                    visited[i][j][0][0] = true;
                    int check = 0; // 먹은 디저트 종류 수
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
 
                        if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
 
                        if(maps[nx][ny] != maps[i][j]) {
                            ate[maps[nx][ny]] = true; // 넣고
                            visited[nx][ny][k][0] = true;
                            check = 1;
                            dfs(nx, ny, k, 0, check);
                            ate[maps[nx][ny]] = false; // 빼고
                            visited[nx][ny][k][0] = false;
                        }
                    }
                }
            }
            if(answer == 0) answer = -1;
            System.out.println("#"+tc+" "+answer);
        }
    }
 
    static void dfs(int x, int y, int dir, int cnt, int check) {
        if (x == start.x && y == start.y) {
            answer = Math.max(answer,check);
            return;
        }
 
        if(cnt == 3) {
            // dir과 같은 방향으로만 이동가능
            int nx = x + dx[dir];
            int ny = y + dy[dir];
 
            if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if(ate[maps[nx][ny]] == false && visited[nx][ny][dir][cnt] == false) { // 이미 먹은 디저트가 아니어야 함
                    ate[maps[nx][ny]] = true;
                    visited[nx][ny][dir][cnt] = true;
                    check += 1;
                    dfs(nx, ny, dir, cnt, check);
                    ate[maps[nx][ny]] = false; // 여기로 올 일이 있을까? 싶긴한데 일단 제거
                    visited[nx][ny][dir][cnt] = false;
                    check -= 1;
                }
            }
        } else if(cnt < 3){
            for (int k = 0; k < 4; k++) {
                if(k != (dir+2)%4){ // 반대 방향은 아니어야 함 다시 돌아가는 건 안되니까 ..
                    int nx = x + dx[k];
                    int ny = y + dy[k];
     
                    if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
     
                    if(ate[maps[nx][ny]] == false) {  // 이미 먹은 디저트가 아니어야 함
                        ate[maps[nx][ny]] = true; // 넣고
                        visited[nx][ny][dir][cnt] = true;
                        check += 1;
                        if(k == dir) dfs(nx, ny, k, cnt, check);
                        else dfs(nx, ny, k, cnt+1, check);
                        ate[maps[nx][ny]] = false;  // 빼고
                        visited[nx][ny][dir][cnt] = false;
                        check -= 1;
                    }
                }
            }
        }
    }
}
