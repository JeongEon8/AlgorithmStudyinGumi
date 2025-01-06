import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        
        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};

        int answer = 0;

        int[][] maps = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true) {
            boolean[][] visited = new boolean[N][N];
            int unionCnt = 0;
            ArrayList<Point>[] unions = new ArrayList[N*N];
            int[] populations = new int[N*N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(visited[i][j] == false){
                        Queue<Point> queue = new LinkedList<>();
                        queue.add(new Point(i, j));
                        populations[unionCnt] = maps[i][j];
                        visited[i][j] = true;
                        while (queue.size() != 0) { 
                            Point p = queue.poll();
                            for (int l = 0; l < 4; l++) {
                                int nx = p.x+dx[l];
                                int ny = p.y+dy[l];
            
                                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            
                                int diff = Math.abs(maps[nx][ny] - maps[p.x][p.y]);
                                if(visited[nx][ny] == false && diff >= L && diff <= R) {
                                    queue.add(new Point(nx,ny));
                                    visited[nx][ny] = true;
                                    populations[unionCnt] += maps[nx][ny];
                                    if(unions[unionCnt] == null) {
                                        ArrayList<Point> tmp = new ArrayList<>();
                                        tmp.add(new Point(p.x,p.y));
                                        tmp.add(new Point(nx, ny));
                                        unions[unionCnt] = tmp;
                                    }else unions[unionCnt].add(new Point(nx, ny));
                                }
                            }
                        }
                        if(unions[unionCnt] != null) {
                            // 이동했음
                            unionCnt += 1;
                        }
                    }
                }
            }
            // 종료 조건 인구이동이 일어나지 않을 경우
            if(unionCnt == 0) break;
            else {
                answer += 1;
                // System.out.println("unionCnt "+unionCnt+ " size "+unions[unionCnt-1].size());
                for (int i = 0; i < unionCnt; i++) {
                    int population = (int) Math.ceil(populations[i]/unions[i].size());
                    for (Point country : unions[i]) {
                        maps[country.x][country.y] = population;
                    }               
                }
            }  
        }

        System.out.println(answer);
    }
}
