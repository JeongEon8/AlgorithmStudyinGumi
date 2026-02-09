import java.io.*;
import java.util.*;

public class Main {

    static int[] parent;
    static int[] size;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (!union(a, b)) {
                ans = i + 1;
                break;
            }
        }
        System.out.println(ans);
    }

    static int find(int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return false; // cycle
        if (size[a] < size[b]) {
            int t = a;
            a = b;
            b = t;
        }
        parent[b] = a;
        size[a] += size[b];
        return true;
    }
}