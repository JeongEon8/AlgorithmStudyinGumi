import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3020 {

    static int N, H;
    static int[] diff, count;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        diff = new int[H + 1];
        for (int i = 0; i < N; i++) {
            int h = Integer.parseInt(br.readLine());
            if (i % 2 == 0) {
                diff[0]++;
                diff[h]--;
            } else {
                diff[H - h]++;
                diff[H]--;
            }
        }

        // 누적합 구하기
        count = new int[H];
        count[0] = diff[0];
        for (int i = 1; i < H; i++) {
            count[i] = count[i - 1] + diff[i];
        }

        Arrays.sort(count);
        System.out.println(count[0] + " " + binarySearch(count[0]));
    }

    static int binarySearch(int target) {
        int left = 0, right = H;
        int ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (count[mid] > target) {
                // target 보다 처음으로 큰 수 구하기
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
