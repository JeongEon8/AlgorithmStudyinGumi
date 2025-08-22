import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int array[] = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        int a = 0;
        int sum = 0;
        int answer = 0;
        for (int b = 0; b < n; b++) {
            sum += array[b];
            if (sum == goal) answer++;
            while (sum >= goal) {
                sum -= array[a];
                a++;
                if (sum == goal) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
