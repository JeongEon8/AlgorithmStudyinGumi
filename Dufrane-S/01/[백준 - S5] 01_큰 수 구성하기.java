import java.io.*;
import java.util.*;

public class Main {

    static int answer = 0;
    static int n = 0;
    static int max = 0;
    static List<Integer> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        max = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);
        dfs(0, "");
        System.out.println(answer);
    }

    private static void dfs(int a, String s) {
        if (!s.isEmpty()) {
            int now = Integer.parseInt(s);
            if (now > max) return;
            if (now > answer) answer = now;
        }

        for (int i = 0; i < n; i++) {
            dfs(a + 1, s + list.get(i));
        }

    }
}
