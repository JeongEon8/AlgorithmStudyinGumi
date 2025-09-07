import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

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

        int answer = 0;

        while(pQueue.size() > 1) {
            int first = pQueue.poll();
            int second = pQueue.poll();

            answer += first+second;

            pQueue.add(first+second);
        }

        System.out.println(answer);

    }
}
