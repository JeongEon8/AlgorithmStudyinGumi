import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[][] maps = new char[R][C];
        boolean[][] visited = new boolean[R][C];

        int[] answer = new int[2];

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        for(int i = 0; i < R; i++) {
            st = new StringTokenizer(bf.readLine());
            String str = st.nextToken();
            for(int j = 0; j < C; j++) {
                maps[i][j] = str.charAt(j);
            }
        }

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(visited[i][j] == false && (maps[i][j] == 'v' || maps[i][j] == 'o')) {
                    int sheep = 0;
                    int wolf = 0;

                    Queue<Point> q = new LinkedList<>();
                    q.add(new Point(i,j));
                    visited[i][j] = true;

                    while(q.size() > 0) {
                        Point cur = q.poll();
                        switch(maps[cur.x][cur.y]) {
                            case 'v': wolf++;
                            break;
                            case 'o': sheep++;
                        }
                        
                        for(int l = 0; l < 4; l++) {
                            int nx = cur.x + dx[l];
                            int ny = cur.y + dy[l];

                            if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;

                            if(visited[nx][ny] == false && maps[nx][ny] != '#') {
                                visited[nx][ny] = true;
                                q.add(new Point(nx, ny));
                            }
                        }
                    }
                    if(sheep <= wolf) sheep = 0;
                    else wolf = 0;

                    answer[0] += sheep;
                    answer[1] += wolf;
                }
            }
        }
        System.out.println(answer[0]+" "+answer[1]);
    }
}
