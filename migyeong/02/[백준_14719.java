import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b14719 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        int H = Integer.parseInt(split[0]);
        int W = Integer.parseInt(split[1]);

        split = br.readLine().split(" ");
        int[] list = new int[W];

        for (int i = 0; i < W; i++) {
            list[i] = Integer.parseInt(split[i]);
        }

        int result = 0;

        for (int i = 1; i < W - 1; i++) {
            int leftMax = 0;
            int rightMax = 0;

            for(int j = 0; j < i; j++) {
                leftMax = Math.max(leftMax, list[j]);
            }

            for(int j = i+1; j < W; j++) {
                rightMax = Math.max(rightMax, list[j]);
            }

            int water = Math.min(leftMax, rightMax) - list[i];

            if(water > 0) {
                result += water;
            }

        }

        System.out.println(result);
    }
}
