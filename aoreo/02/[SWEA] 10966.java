import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {

    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("input_10966.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int moves = 0;

            char[][] maps = new char[N][M];
            ArrayList<Point> waters = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(bf.readLine());
                String str = st.nextToken();
                for (int j = 0; j < M; j++) {
                    maps[i][j] = str.charAt(j);
                    if (maps[i][j] == 'W') {
                        waters.add(new Point(i, j));
                    }
                }
            }
            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};
            int[][] visited = new int[N][M];
            for (Point water : waters) {
                if(visited[water.x][water.y] == 0){
                    visited[water.x][water.y] = 1;
                    Queue<Point> queue = new LinkedList<>();
                    queue.add(new Point(water.x, water.y));
    
                    while (queue.size() != 0) {
                        Point p = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int nx = p.x + dx[k];
                            int ny = p.y + dy[k];
    
                            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                            
                            if (maps[nx][ny] == 'L' && (visited[nx][ny] == 0 || visited[nx][ny] > visited[p.x][p.y] + 1)) {
                                queue.add(new Point(nx, ny));
                                if(visited[nx][ny] != 0){
                                    moves = moves - visited[nx][ny] + 1;
                                    visited[nx][ny] = visited[p.x][p.y] + 1;
                                    moves = moves + visited[nx][ny] - 1;
                                }else{
                                    visited[nx][ny] = visited[p.x][p.y] + 1;
                                    moves = moves + visited[nx][ny] - 1;
                                }
                            }else if(maps[nx][ny] == 'W' && visited[nx][ny] == 0){
                                visited[nx][ny] = 1;
                                queue.add(new Point(nx, ny));
                            }
                        }
                    }
                }
            }
            System.out.println("#" + tc + " " + moves);
        }
    }
}
