import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> q = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        int[] answers = new int[t];
        for (int i = 0; i < t; i++) {
            q.add(Integer.parseInt(st.nextToken()));
            q2.add(i);
        }

        int count = 1;
        while (!q2.isEmpty()) {
            int now = q.poll();
            int order = q2.poll();
            if (--now > 0) {
                q.add(now);
                q2.add(order);
            } else {
                answers[order] = count;
            }
            count++;
        }
        StringBuilder sb = new StringBuilder();
        for (int now : answers) {
            sb.append(now);
            sb.append(' ');
        }
        System.out.println(sb);

    }
}
