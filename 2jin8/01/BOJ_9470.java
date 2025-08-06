import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9470 {

    static int K, M, P;
    static int[] inDegree, order;
    static ArrayList<Integer>[] graph, rgraph;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken()); // 테스트 케이스 번호
            M = Integer.parseInt(st.nextToken()); // 노드의 수
            P = Integer.parseInt(st.nextToken()); // 간선의 수
            inDegree = new int[M + 1];
            order = new int[M + 1];
            graph = new ArrayList[M + 1];
            rgraph = new ArrayList[M + 1];
            for (int i = 1; i <= M; i++) {
                graph[i] = new ArrayList<>();
                rgraph[i] = new ArrayList<>();
            }

            for (int i = 0; i < P; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                rgraph[b].add(a);
                inDegree[b]++;
            }

            // 진입 차수가 0이면 "강의 근원" == 큐에 넣기 & 순서는 1
            Queue<Integer> queue = new ArrayDeque<>();
            for (int i = 1; i <= M; i++) {
                if (inDegree[i] == 0) {
                    queue.offer(i);
                    order[i] = 1;
                }
            }

            while (!queue.isEmpty()) {
                int now = queue.poll();

                for (int next : graph[now]) {
                    // 모든 노드와 연결이 끊어지는 경우
                    if (--inDegree[next] == 0) {
                        // 최댓값 & 최댓값 개수 구하기
                        int max = 0, count = 0;
                        for (int before : rgraph[next]) {
                            if (max < order[before]) {
                                count = 1;
                                max = order[before];
                            } else if (max == order[before]) {
                                count++;
                            }
                        }

                        // 최댓값이 2개 이상이면 최댓값 + 1, 아니면 최댓값
                        queue.offer(next);
                        order[next] = count > 1? max + 1 : max;
                    }
                }
            }
            sb.append(K).append(" ").append(order[M]).append("\n");
        }
        System.out.println(sb);
    }
}
