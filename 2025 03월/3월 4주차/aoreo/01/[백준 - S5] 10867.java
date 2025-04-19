import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken()); // 정수 개수

        Set<Integer> set = new HashSet<>();
        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < N; i++) {
            set.add(Integer.valueOf(st.nextToken()));
        }

        PriorityQueue<Integer> pQueue = new PriorityQueue<>();

        for (Integer e : set) {
            pQueue.add(e);
        }

        while(pQueue.size() != 0) {
            int num = pQueue.poll();
            System.out.print(num+" ");
        }
    }
}
