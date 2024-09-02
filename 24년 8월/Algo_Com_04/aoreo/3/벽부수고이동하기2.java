import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int N;
    static int M;
    static int K;
    static Character[][] maps;
    static int[][][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws Exception {
    
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        maps = new Character[N][M];
        visited = new int[N][M][K+1];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            String str = st.nextToken();
            for (int j = 0; j < M; j++) {
                maps[i][j] = str.charAt(j);
            }
        }

        int answer = bfs();
        System.out.println(answer);
        
    }

    static int bfs(){
        int answer = -1;
        Queue<int []> queue = new LinkedList<>();
        int[] start = {0,0,0}; // 0번째 x, 1번째 y, 2번째 부신 횟수
        queue.add(start);
        visited[0][0][0] = 1;
        
        while(queue.size() != 0){
            int[] p = queue.poll();

            if(p[0] == N - 1 && p[1] == M - 1){
                queue.clear();
                answer = visited[N-1][M-1][p[2]];
                return answer;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = p[0] + dx[i];
                int nextY = p[1] + dy[i];
                int hitCount = p[2];
                if(!checkRange(nextX, nextY)) continue;
                // if(visited[nextX][nextY][hitCount] > 0 && visited[nextX][nextY][hitCount] < visited[p[0]][p[1]][hitCount] + 1) continue;
                // if (visited[nextX][nextY][hitCount] > 0) continue;
                
                if(visited[nextX][nextY][hitCount] == 0 && maps[nextX][nextY] == '0'){
                    int[] nextNode = {nextX, nextY, hitCount};
                    queue.add(nextNode);
                    visited[nextX][nextY][hitCount] = visited[p[0]][p[1]][hitCount] + 1;
                } 
                if(maps[nextX][nextY] == '1' && hitCount < K && visited[nextX][nextY][hitCount+1] == 0 ) { // 벽 부수기
                    int[] nextNode = {nextX, nextY, hitCount+1};
                    queue.add(nextNode);
                    visited[nextX][nextY][hitCount+1] = visited[p[0]][p[1]][hitCount] + 1;
                }
            }
        }
        return answer;
    }

    static boolean checkRange(int nextX, int nextY){
        if(nextX > -1 && nextX < N && nextY > -1 && nextY < M) return true;
        else return false;
    }
}
