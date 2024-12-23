import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        List<Hole> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new Hole(a, b));
        }
        list.sort(null);
        int answer = 0;
        int before = 0;
        for (Hole hole : list) {
            if (before > hole.end) continue;
            int length;
            if (hole.start < before) {
                length = hole.end - before;
            } else {
                length = hole.end - hole.start;
                before = hole.start;
            }
            int tmp;
            if (length % L == 0) {
                tmp = length / L;
            } else {
                tmp = length / L + 1;
            }
            before = before + tmp * L;
            answer += tmp;
        }
        System.out.print(answer);
    }
}

class Hole implements Comparable<Hole> {

    public Hole(int a, int b) {
        this.start = a;
        this.end = b;
    }

    int start;
    int end;

    @Override
    public int compareTo(Hole a) {
        return this.start - a.start;
    }
};
