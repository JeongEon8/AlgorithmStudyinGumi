import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class b13549 {
    static int n, k;
    static int max = 100000;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);

        int[] time = new int[max + 1];
        Arrays.fill(time, -1);
        Deque<Integer> dq = new ArrayDeque<>();
        
        dq.offerFirst(n);
        time[n] = 0;

        while (!dq.isEmpty()) {
            int x = dq.poll();

            // 순간이동 (우선순위 높음)
            if (x * 2 <= max && time[x * 2] == -1) {
                time[x * 2] = time[x];
                dq.offerFirst(x * 2); // 0초니까 앞에 넣기
            }

            // x - 1
            if (x - 1 >= 0 && time[x - 1] == -1) {
                time[x - 1] = time[x] + 1;
                dq.offerLast(x - 1); // 1초니까 뒤에 넣기
            }

            // x + 1
            if (x + 1 <= max && time[x + 1] == -1) {
                time[x + 1] = time[x] + 1;
                dq.offerLast(x + 1); // 1초니까 뒤에 넣기
            }
        }

        System.out.println(time[k]);
    }
}
