import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class BOJ_16234 {
 
    static int N, L, R;
    static int[][] population;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static ArrayList<Node> migrationNodes;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
 
        population = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                population[i][j] = Integer.parseInt(st.nextToken());
            }
        }
 
        System.out.println(move());
    }
    // 인구 이동이 가능한지 확인하고, 가능하면 이동동
    public static int move() {
        int result = 0;
        while (true) {
            boolean isMove = false;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        int sum = bfs(i, j);
                        if (migrationNodes.size() > 1) {
                            changePopulation(sum);
                            isMove = true;
                        }
                    }
                }
            }
            if (!isMove)
                return result;
            result++;
        }
    }
    // 국경선이 열릴 수 있는 나라들을 탐색
    public static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        migrationNodes = new ArrayList<>();
 
        q.offer(new Node(x, y));
        migrationNodes.add(new Node(x, y));
        visited[x][y] = true;
 
        int sum = population[x][y];
        while (!q.isEmpty()) {
            Node current = q.poll();
 
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
                    int diff = Math.abs(population[current.x][current.y] - population[nx][ny]);
                    if (L <= diff && diff <= R) {
                        q.offer(new Node(nx, ny));
                        migrationNodes.add(new Node(nx, ny));
                        sum += population[nx][ny];
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return sum;
    }
    // 포함된 나라들의 인구 평균값 갱신신
    public static void changePopulation(int sum) {
        int avg = sum / migrationNodes.size();
        for (Node node : migrationNodes) {
            population[node.x][node.y] = avg;
        }
    }
 
    public static class Node {
        int x;
        int y;
 
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}