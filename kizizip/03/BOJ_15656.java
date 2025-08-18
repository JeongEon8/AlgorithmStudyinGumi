import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_15656 {
    static int n, m;
    static ArrayList<Integer> list;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        Collections.sort(list);

        arr = new int[m];
        dfs(0);

        System.out.print(sb);
    }

    static void dfs(int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            arr[depth] = list.get(i);
            dfs(depth + 1);
        }
    }
}
