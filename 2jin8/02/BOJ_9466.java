import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9466 {

    static int N, notTeam; // notTeam: 팀에 속하지 못한 학생 수
    static int[] arr;
    static boolean[] done, visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N + 1];
            done = new boolean[N + 1];
            visited = new boolean[N + 1];

            notTeam = N;
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());

                // 자기 자신을 선택한 경우 (=혼자 팀)
                if (i == arr[i]) {
                    done[i] = true;
                    notTeam--;
                }
            }

            for (int i = 1; i <= N; i++) {
                if (done[i]) continue;

                checkTeam(i);
            }
            sb.append(notTeam).append("\n");
        }
        System.out.println(sb);
    }

    static void checkTeam(int student) {
        // 이미 팀 확인 완료한 학생인 경우
        if (done[student]) return;

        // 팀 확인 완료하지 않았는데 이미 방문한 경우
        if (visited[student]) { // 사이클 발생 == 팀에 속함
            notTeam--;
            done[student] = true;
        }

        visited[student] = true;
        checkTeam(arr[student]);
        visited[student] = false;

        done[student] = true;
    }
}
