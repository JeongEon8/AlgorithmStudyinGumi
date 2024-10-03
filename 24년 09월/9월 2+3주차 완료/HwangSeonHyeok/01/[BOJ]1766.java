import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    static class Problem implements Comparable<Problem> {
        int num;
        List<Integer> next;

        public Problem(int num) {
            this.num = num;
            next = new ArrayList<Integer>();
        }

        @Override
        public int compareTo(Problem o) {
            return this.num - o.num;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        String[] split = in.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        int[] back = new int[n + 1];
        List<Problem> pList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            pList.add(new Problem(i));
        }
        for (int i = 0; i < m; i++) {
            split = in.readLine().split(" ");
            int from = Integer.parseInt(split[0]);
            int to = Integer.parseInt(split[1]);
            back[to]++;
            pList.get(from).next.add(to);
        }
        PriorityQueue<Problem> pq = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            if (back[i] == 0) {
                pq.add(pList.get(i));
            }
        }
        while (!pq.isEmpty()) {
            Problem p = pq.poll();
            sb.append(p.num + " ");
            for (int next : p.next) {
                if (--back[next] == 0) {
                    pq.add(pList.get(next));
                }
            }
        }
        System.out.println(sb);

    }

}