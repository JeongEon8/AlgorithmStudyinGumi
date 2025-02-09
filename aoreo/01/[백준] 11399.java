import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken()); // 사람 수

        PriorityQueue<Integer> pQueue = new PriorityQueue<>();

        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < N; i++) {
            pQueue.add(Integer.valueOf(st.nextToken()));
        }

        int answer = 0;

        while(pQueue.size() != 0) {
            int time = pQueue.poll();

            answer += time * N;

            N -= 1;
        }

        System.out.println(answer);
    }
}
