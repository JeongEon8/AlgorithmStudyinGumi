import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16401 {

    static int M, N, totalSnack;
    static int[] snacks;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        snacks = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            snacks[i] = Integer.parseInt(st.nextToken());
            totalSnack += snacks[i];
        }
        Arrays.sort(snacks);

        System.out.println(separateSnack());;
    }

    static int separateSnack() {
        int ans = 0;
        int left = 1, right = 1_000_000_000;
        while (left <= right) {
            int mid = (left + right) / 2; // 과자의 길이
            if (isSeparate(mid)) { // M명보다 많이 나눠줄 수 있는 경우 => 기록 & 길이 늘리기
                ans = mid;
                left = mid + 1;
            } else { // M명보다 적게 나눠줄 수 있는 경우 => 길이 줄이기
                right = mid - 1;
            }
        }
        return ans;
    }

    // 막대 과자는 여러 조각으로 나눠질 수 있음 => 10 -> 5, 5 (O)
    // 과자를 하나로 합칠 수는 없음 => 5 + 5 -> 10 (X)
    static boolean isSeparate(int length) {
        int total = 0;
        for (int i = 0; i < N; i++) {
            total += snacks[i] / length;
            if (total >= M) return true;
        }
        return false;
    }
}
