import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_2668 {

    static int N;
    static int[] arr;
    static boolean[] done, checked;
    static ArrayList<Integer> answer = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        done = new boolean[N + 1];
        checked = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (i == arr[i]) {
                done[i] = true;
                answer.add(i);
            }
        }

        for (int i = 1; i <= N; i++) {
            // 이미 탐색 완료한 경우
            if (done[i]) continue;

            dfs(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(answer.size()).append("\n");
        answer.stream().sorted()
                .forEach(a -> sb.append(a).append("\n"));
        System.out.println(sb);
    }

    static void dfs(int idx) {
        // 이미 탐색한 경우
        if (done[idx]) return;

        // 탐색이 완료되지 않았지만 이미 방문한 경우 => 사이클 발생
        if (checked[idx]) {
            // 집합에 넣기 & 탐색 완료 처리
            answer.add(idx);
            done[idx] = true;
        }

        checked[idx] = true;
        dfs(arr[idx]);
        checked[idx] = false;

        done[idx] = true;
    }
}
