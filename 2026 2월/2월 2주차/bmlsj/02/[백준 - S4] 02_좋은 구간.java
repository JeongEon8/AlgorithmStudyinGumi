
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int S;
    static int[] nums;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = Integer.parseInt(br.readLine());
        nums = new int[S];

        String[] split = br.readLine().split(" ");

        for (int i = 0; i < S; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }

        Arrays.sort(nums);

        int n = Integer.parseInt(br.readLine());
        int left = 0, right = 0;
        for (int i = 0; i < S - 1; i++) {
            if (n < nums[0]) {
                left = 0;
                right = nums[0];
                break;
            }

            if (nums[i] <= n && nums[i + 1] >= n) {
                left = nums[i];
                right = nums[i + 1];
                break;
            }
        }

        // System.out.println(left + " " + right);
        int ans = 0;
        for (int i = left + 1; i < right - 1; i++) {
            for (int j = i + 1; j < right; j++) {
                if (i <= n && n <= j) {
                    // System.out.println(i + " " + j);
                    ans++;
                }
            }
        }

        System.out.println(ans);

    }

}
