import java.io.*;
import java.util.*;

class Main {
    static int answer = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());

        int[] kits = new int[N];

        for(int i = 0; i < N; i++) {
            kits[i] = Integer.parseInt(st.nextToken());
        }

        perm(0, N, new int[N], new boolean[N], kits, K);

        System.out.println(answer);
    }

    public static void perm(int r, int n, int[] sel, boolean[] visited, int[] kits, int k) {
        if(r == n) {
            int weight = 500;
            for(int i = 0; i < n; i++) {
                weight -= k;
                weight += sel[i];
                if(weight < 500) return;
            }
            answer++;
            return;
        }
        for(int i = 0; i < n; i++) {
            if(visited[i] == false) {
                sel[r] = kits[i];
                visited[i] = true;
                perm(r+1, n, sel, visited, kits, k);
                visited[i] = false;
            }
        }
    }
}
