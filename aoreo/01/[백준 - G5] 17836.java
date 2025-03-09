import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        String answer = "Fail";

        int[][][] visited = new int[2][N][M];
        int[][] maps = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
            }     
        }
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0,0, 0)); // 시작지점
        visited[0][0][0] = 1;

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        
        while(queue.isEmpty() == false) {
            Node start = queue.poll();
            if(start.x == N-1 && start.y == M-1) {
                answer = String.valueOf(visited[start.hasSword][start.x][start.y]-1);
                break;
            }

            if(visited[start.hasSword][start.x][start.y] > T+1) {
                answer = "Fail";
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = start.x + dx[i];
                int ny = start.y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue; // 지도 밖

                if((start.hasSword == 0 && maps[nx][ny] == 1) || visited[start.hasSword][nx][ny] != 0) continue; // 이동할 수 없음

                if((start.hasSword == 0 && maps[nx][ny] == 2) || start.hasSword == 1 ) { // 그람을 획득했거나 소지하고 있는 경우
                    queue.add(new Node(1, nx, ny));
                    visited[1][nx][ny] = visited[start.hasSword][start.x][start.y] + 1;
                } else if(start.hasSword == 0 && maps[nx][ny] == 0) {
                    queue.add(new Node(start.hasSword, nx, ny));
                    visited[start.hasSword][nx][ny] = visited[start.hasSword][start.x][start.y] + 1;
                }
            }
        }
        System.out.println(answer);
    }

    static class Node {
        int x;
        int y;
        int hasSword; // 0이 없는 거, 1이 있는 거 

        public Node( int hasSword, int x, int y) {
            this.x = x;
            this.y = y;
            this.hasSword = hasSword;
        }
    }
}
