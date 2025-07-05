import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);

        boolean[][] graph = new boolean[N + 1][N + 1];

        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            split = br.readLine().split(" ");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);

            graph[a][b] = true;  // a < b 관계 설정
        }

        // 플로이드-워셜
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (graph[i][k] && graph[k][j]) {
                        graph[i][j] = true;
                    }
                }
            }
        }

        int result = 0;

        // 각 학생에 대해 자신보다 크거나 작은 학생의 수를 계산
        for (int i = 1; i <= N; i++) {
            int count = 0;
            for (int j = 1; j <= N; j++) {
                if (graph[i][j] || graph[j][i]) {
                    count++;
                }
            }

            // 자신의 순서를 확실히 알 수 있는 학생이면 결과 증가
            if (count == N - 1) {
                result++;
            }
        }

        System.out.println(result);
    }
}
