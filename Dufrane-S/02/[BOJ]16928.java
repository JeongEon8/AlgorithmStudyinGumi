import java.io.*;
import java.util.*;

public class Main {

    static int[] routes = new int[101];
    static int[] counts = new int[101];
    static int answer = Integer.MAX_VALUE;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            routes[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            routes[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        Queue<Dot> q = new ArrayDeque<>();
        q.add(new Dot(0, 1));
        while (!q.isEmpty()) {
            Dot now = q.poll();
            if (now.count >= answer) continue;
            if (now.pos >= 100) {
                answer = now.count;
                continue;
            }
            if (counts[now.pos] != 0 && now.count >= counts[now.pos]) continue;
            counts[now.pos] = now.count;
            int nowPos = now.pos;
            int nowCount = now.count;
            for (int i = nowPos + 1; i < nowPos + 7; i++) {
                if (i > 100) continue;
                if (counts[i] != 0 && nowCount + 1 >= counts[i]) continue;
                if (routes[i] != 0) {
                    q.add(new Dot(now.count + 1, routes[i]));
                } else {
                    q.add(new Dot(now.count + 1, i));
                }
            }
        }

        System.out.println(answer);
    }
}

class Dot {
    int pos;
    int count;

    public Dot(int count, int pos) {
        this.pos = pos;
        this.count = count;
    }
}
