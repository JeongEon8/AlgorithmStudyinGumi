import java.util.*;
import java.io.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Integer.parseInt(st.nextToken());
        long m = Integer.parseInt(st.nextToken());
        Queue<Long> q = new LinkedList<>();
        int count = 0;
        q.add(n);
        while (!q.isEmpty()) {
            int qsize= q.size();
            count++;
            for (int k = 0; k < qsize; k++) {
                long now = q.poll();
                if (now == m) {
                    System.out.println(count);
                    return;
                }
                if (now > m) continue;
                q.add(now * 2);
                q.add(now * 10 + 1);
            }
        }
        System.out.println("-1");
    }
}
