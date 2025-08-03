import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class BOJ_15654 {
    static int n, m;
    static int[] input, output;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);

        input = new int[n];
        output = new int[m];
        visited = new boolean[n];

        line = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(line[i]);
        }

        Arrays.sort(input);  // 사전 순 출력을 위해 정렬
        backtrack(0);
    }

    static void backtrack(int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(output[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = input[i];
                backtrack(depth + 1);
                visited[i] = false;  // 백트래킹을 위한 방문처리
            }
        }
    }
}
