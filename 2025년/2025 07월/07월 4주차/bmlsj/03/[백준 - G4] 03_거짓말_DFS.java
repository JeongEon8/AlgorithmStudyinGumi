import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 거짓말_DFS {

    private static int N, M;
    private static boolean[] visited;
    private static List<Integer>[] graph;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]); // 사람수
        M = Integer.parseInt(split[1]); // 파티수

        split = br.readLine().split(" ");
        int realN = Integer.parseInt(split[0]); // 진실 아는 사람 수

        if (realN == 0) { // 아무도 없을 경우, 모든 파티에 참석
            System.out.println(M);
            return;
        }

        int[] realPerson = new int[split.length - 1];
        visited = new boolean[N + 1];
        if (realN >= 1) {
            for (int i = 1; i <= realN; i++) {
                realPerson[i - 1] = Integer.parseInt(split[i]);
                visited[Integer.parseInt(split[i])] = true;
            }
        }

        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        int ans = M;

        List<Integer>[] parties = new ArrayList[M];
        for (int i = 0; i < M; i++) {
            split = br.readLine().split(" ");
            parties[i] = new ArrayList<>();

            for (int j = 1; j < split.length - 1; j++) {
                for (int k = j + 1; k < split.length; k++) {
                    graph[Integer.parseInt(split[k])].add(Integer.parseInt(split[j]));
                    graph[Integer.parseInt(split[j])].add(Integer.parseInt(split[k]));
                }
            }

            for (int j = 1; j < split.length; j++) {
                parties[i].add(Integer.parseInt(split[j]));
            }
        }

        for (int i = 1; i <= N; i++) {
            party(i);
        }
        for (int i = 0; i < M; i++) {
            for (int num : parties[i]) {
                if (visited[num]) {
                    ans--;
                    break;
                }
            }
        }

        System.out.println(ans);

    }

    static void party(int person) {

        if (visited[person]) {
            for (int next : graph[person]) {
                if (!visited[next]) {
                    visited[next] = true;
                    party(next);
                }
            }
        }

    }
}
