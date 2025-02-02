import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        int done[] = new int[1000001];
        int counts[] = new int[1000001];
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        Queue<Position> q = new ArrayDeque<>();
        q.add(new Position(start, 0));
        while (!q.isEmpty()) {
            Position now = q.poll();
            if (done[now.pos] == 1 && now.count > counts[now.pos]) continue;
            if (now.pos == end) {
                done[now.pos] = 1;
                counts[now.pos] = now.count;
                answer++;
                continue;
            }
            done[now.pos] = 1;
            counts[now.pos] = now.count;
            if (now.pos < end) {
                if (now.pos - 1 >= 0) {
                    q.add(new Position(now.pos - 1, now.count + 1));
                }
                if (now.pos != 0 && now.pos * 2 <= 100000) {
                    q.add(new Position(now.pos * 2, now.count + 1));
                }
                q.add(new Position(now.pos + 1, now.count + 1));
            } else {
                q.add(new Position(now.pos - 1, now.count + 1));
            }
        }
        System.out.println(counts[end]);
        System.out.println(answer);
    }


}

class Position {
    int pos;
    int count;

    public Position(int pos, int count) {
        this.pos = pos;
        this.count = count;
    }
}
