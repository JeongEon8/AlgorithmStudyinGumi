import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }
        int answer = 0;
        while (pq.size() != 1) {
            int n = pq.poll();
            int m = pq.poll();
            answer += (m + n);
            pq.add(n + m);
        }
        System.out.println(answer);
    }
}
