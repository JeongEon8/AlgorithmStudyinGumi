import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int X = Integer.parseInt(st.nextToken());

        int sum = 64;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(64);

        while(sum > X) {
            int shortLen = pq.poll();
            if(sum - shortLen/2 >= X) {
                sum -= shortLen/2;
            } else pq.add(shortLen/2);
            pq.add(shortLen/2);
        }

        System.out.println(pq.size());
    }
}
