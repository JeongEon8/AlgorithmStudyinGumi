import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static String a;
    static int b;
    static boolean[] visited;
    static int ans = -1;

    static void permutation(int depth, long current) {
        if (depth == a.length()) {
            if (current < b && ans < current) {
                ans = (int) current;
            }
            return;
        }
        for (int i = 0; i < a.length(); i++) {
            if (depth == 0 && a.charAt(i) - '0' == 0) {
                continue;
            }
            if (!visited[i]) {
                visited[i] = true;
                permutation(depth + 1, current * 10 + (a.charAt(i) - '0'));
                visited[i] = false;
            }
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] split = in.readLine().split(" ");
        a = split[0];
        b = Integer.parseInt(split[1]);
        visited = new boolean[a.length()];
        permutation(0, 0);
        System.out.println(ans);

    }

}