import java.util.*;
import java.io.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] list = new ArrayList[n + 1];
        int a, b;
        int[] done = new int[n + 1];
        int[] answer = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while (!q.isEmpty()) {
            int now = q.poll();
            done[now] = 1;
            for (int temp : list[now]) {
                if (done[temp] != 0) continue;
                done[temp] = 1;
                q.add(temp);
                answer[temp] = now;
            }
        }
        for (int i = 2; i <= n; i++) {
            bw.write(Integer.toString(answer[i]));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
