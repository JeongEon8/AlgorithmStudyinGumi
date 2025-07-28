import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b2470 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        String[] split = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }

        Arrays.sort(arr);

        int left = 0;
        int right = n - 1;
        int minDiff = Integer.MAX_VALUE;
        int ansL = 0, ansR = 0;

        while(left < right) {
            int sum = arr[left] + arr[right];
            int absSum = Math.abs(sum);

            if(absSum < minDiff) {
                minDiff = absSum;
                ansL = arr[left];
                ansR = arr[right];
            }

            if(sum < 0) left++;
            else right--;
        }

        System.out.println(ansL + " " + ansR);
    }
}
