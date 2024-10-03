import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
class Solution {
    static int[] dx = {0,0,-1,1,1,1,-1,-1};
    static int[] dy = {1,-1,0,0,1,-1,1,-1};
    static int N;
    static int[][] bombMaps;
    static boolean[][] bombs;
    static boolean[][] visited;
 
    public static void main(String args[]) throws Exception {
 
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
 
        StringTokenizer st = new StringTokenizer(bf.readLine());
 
        int T = Integer.parseInt(st.nextToken()); // 테케 개수
 
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken()); // 가로세로 길이
 
            bombs = new boolean[N][N];
            bombMaps = new int[N][N];
            visited = new boolean[N][N];
 
            for (int i = 0; i < N; i++) { 
                st = new StringTokenizer(bf.readLine());
                String check = st.nextToken();
                for (int j = 0; j < N; j++) {
                    if(check.charAt(j) == '*'){
                        bombs[i][j] = true;
                    }else {
                        bombs[i][j] = false; // false가 지뢰가 없는 곳
                    }
                }
            }
 
            int moves = 0;
            for(int j = 0; j < N; j++){
                for (int k = 0; k < N; k++){
                    if(bombs[j][k] == false && visited[j][k] == false && countBomb(new Point(j,k), N) == 0){ // 주변이 다 0인 곳
                        Queue<Point> queue = new LinkedList<>();
                        queue.add(new Point(j,k));
                        visited[j][k] = true;
                        moves += 1;
                        while(queue.size() != 0) {
                            Point curNode = queue.poll();
                            for (int i = 0; i < 8; i++) {
                                int nextX = curNode.x + dx[i];
                                int nextY = curNode.y + dy[i];
                             
                                if(nextX > -1 && nextX < N && nextY > -1 && nextY < N && bombs[nextX][nextY] == false && visited[nextX][nextY] == false && countBomb(new Point(nextX, nextY), N) == 0) {
                                        queue.add(new Point(nextX, nextY));
                                        visited[nextX][nextY] = true;
                                }else if(nextX > -1 && nextX < N && nextY > -1 && nextY < N && bombs[nextX][nextY] == false && visited[nextX][nextY] == false && countBomb(new Point(nextX, nextY), N) > 0) {
                                    visited[nextX][nextY] = true;
                                }
                        }
                    }
                }
            }
        }
 
            for(int l = 0; l < N; l++){
                for (int n = 0; n < N; n++) {
                    if(bombs[l][n] == false && visited[l][n] == false && bombMaps[l][n] != 0) {
                        bombMaps[l][n] = 1;
                        moves += 1;
                    }
                }
            }
            System.out.println("#" + test_case+" "+moves);
 
        }
    }
 
    public static int countBomb(Point curNode, int N){
        int bombsCount = 0;
 
        for (int i = 0; i < 8; i++) {
            int nextX = curNode.x + dx[i];
            int nextY = curNode.y + dy[i];
         
            if(nextX > -1 && nextX < N && nextY > -1 && nextY < N && bombs[nextX][nextY] == true) {
                bombsCount += 1;
            }
        }
        bombMaps[curNode.x][curNode.y] = bombsCount;
        return bombsCount;
    }
}
