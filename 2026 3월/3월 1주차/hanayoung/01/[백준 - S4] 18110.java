import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(bf.readLine()));
        }

        int exceptNum = Math.round((float)n*15/100);
        for(int i = 0; i < exceptNum; i++) {
            pq.poll();
        }

        while(pq.size() > exceptNum) {
            answer += pq.poll();
        }
        answer = Math.round((float)answer/(n-2*exceptNum));

        System.out.println(answer);
    }
}
