import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] split = in.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int s = Integer.parseInt(split[1]);
        int d = Integer.parseInt(split[2]);
        int f = Integer.parseInt(split[3]);
        int b = Integer.parseInt(split[4]);
        int k = Integer.parseInt(split[5]);

        int[] map = new int[n + 1];
        if (k > 0) {
            split = in.readLine().split(" ");
            for (int i = 0; i < k; i++) {
                map[Integer.parseInt(split[i])] = -1;
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        map[s] = 1;
        q.add(s);
        while (!q.isEmpty() && map[d] == 0) {
            int current = q.poll();
            int forward = current + f;
            int back = current - b;
            if (forward <= n && map[forward] == 0) {
                map[forward] = map[current] + 1;
                q.add(forward);
            }

            if (back >= 0 && map[back] == 0) {
                map[back] = map[current] + 1;
                q.add(back);
            }
        }

        if (map[d] == 0) {
            System.out.print("BUG FOUND");
        } else {
            System.out.print(map[d] - 1);
        }

    }

}