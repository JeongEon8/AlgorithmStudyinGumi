import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1952 {

    static int minCost; // 최소 비용
    static int[] costs = new int[4]; // 1일, 1달, 3달, 1년
    static int[] monthPlan = new int[13]; // 1월 ~ 12월

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                costs[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= 12; i++) {
                monthPlan[i] = Integer.parseInt(st.nextToken());
            }

            minCost = Integer.MAX_VALUE;
            dfs(1, 0);
            sb.append("#").append(t).append(" ").append(minCost).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int month, int cost) {
        // 12달 다 확인하면 최소 비용 갱신 후 탐색 종료
        if (month > 12) {
            minCost = Math.min(minCost, cost);
            return;
        }

        // 1일권
        dfs(month + 1, cost + costs[0] * monthPlan[month]);

        // 1달권
        dfs(month + 1, cost + costs[1]);

        // 3달권
        dfs(month + 3, cost + costs[2]);

        // 1년권
        dfs(month + 12, cost + costs[3]);
    }
}
