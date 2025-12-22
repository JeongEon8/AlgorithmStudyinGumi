import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            pQueue.add(Integer.valueOf(st.nextToken()));
        }

        StringBuilder sb = new StringBuilder();

        while(pQueue.size() > 0) {
            sb.append(pQueue.poll()).append("\n");
        }

        System.out.println(sb);
    }
}
