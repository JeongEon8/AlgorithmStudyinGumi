import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] list = new int[n * 2];
        for (int i = 0; i < n * 2; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list);
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = list[i] + list[n * 2 - i - 1];
            if (answer > sum) answer = sum;
        }
        System.out.println(answer);
    }
}
