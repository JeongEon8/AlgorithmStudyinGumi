import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class SWEA_1244 {

    static int n, change, max;
    static int[] nums;
    static HashSet<String> visited = new HashSet<>(); // 중복 확인을 위한 해시셋

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String num = st.nextToken();
            n = num.length();
            change = Integer.parseInt(st.nextToken());
            // 카드 횟수만큼 교환하면 최대값을 찾을 수 있음 (모든 경우의 수 조합 가능)
            if (change > n) change = n;
            nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = num.charAt(i) - '0';
            }

            max = 0;
            visited.clear();
            dfs(0);
            sb.append("#").append(t).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int changeCnt) {
        // 이동 가능 횟수만큼 이동을 끝낸 경우
        if (changeCnt == change) {
            max = Math.max(max, getTotal());
            return;
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                swap(i, j); // 교환하기
                String now = new StringBuilder().append(changeCnt).append(",").append(getTotal()).toString();
                // "교환 횟수, 상금"으로 같은 경우를 진행했는지 확인
                if (!visited.contains(now)) {
                    visited.add(now);
                    dfs(changeCnt + 1);
                }
                swap(i, j); // 교환 취소하기
            }
        }
    }

    static void swap(int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    static int getTotal() {
        int total = 0;
        for (int num : nums) {
            total = total * 10 + num;
        }
        return total;
    }
}