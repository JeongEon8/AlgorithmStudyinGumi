import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10974 {
    static int n;
    static int[] answer;
    static int[] nums;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        answer = new int[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            nums[i] = i+1;
        }

        dfs(0);
        System.out.println(sb);

    }

    static void dfs(int depth) {
        if (depth == n) {
            for (int i = 0; i < n; i++) {
                sb.append(answer[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                answer[depth] = nums[i];
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }
}
