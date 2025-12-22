import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1865 {

    static int N, M, W;
    static int[] dist;
    static ArrayList<Edge>[] edgeList;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < TC; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 지점의 수
            M = Integer.parseInt(st.nextToken()); // 도로의 개수 (+, 양방향)
            W = Integer.parseInt(st.nextToken()); // 웜홀의 개수 (-, 단방향)

            edgeList = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                edgeList[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) { // 도로: 양수 가중치, 양방향
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                edgeList[S].add(new Edge(E, T));
                edgeList[E].add(new Edge(S, T));
            }

            for (int i = 0; i < W; i++) { // 웜홀: 음수 가중치, 단방향
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                edgeList[S].add(new Edge(E, -T));
            }

            dist = new int[N + 1];
            Arrays.fill(dist, 0); // 음수 사이클 탐지용 => 0으로 초기화해도 됨

            // N - 1번 반복
            for (int j = 0; j < N - 1; j++) {
                goTrip();
            }

            // N번째 최단 거리가 갱신된다면 음수 사이클 발생
            sb.append(goTrip() ? "YES" : "NO").append("\n");
        }
        System.out.println(sb);
    }

    static boolean goTrip() {
        boolean isChange = false;

        // 모든 정점에 대해 연결된 간선 확인
        for (int now = 1; now <= N; now++) {
            // 현재 정점과 연결된 간선 확인
            for (Edge next : edgeList[now]) {
                if (dist[next.v] > dist[now] + next.w) { // 더 짧은 거리가 존재하는 경우
                    dist[next.v] = dist[now] + next.w;
                    isChange = true;
                }
            }
        }
        return isChange;
    }

    static class Edge {
        int v, w;

        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}
