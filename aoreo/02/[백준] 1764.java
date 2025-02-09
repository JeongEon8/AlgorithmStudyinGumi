import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken()); // 듣도 못한 사람
        int M = Integer.parseInt(st.nextToken()); // 보도 못한 사람

        HashMap<String, Integer> neverHeard = new HashMap<>();
        PriorityQueue<String> neverHeardAndSeen = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            neverHeard.put(st.nextToken(), 1);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            String next = st.nextToken();

            if(neverHeard.containsKey(next)) neverHeardAndSeen.add(next);
        }

        System.out.println(neverHeardAndSeen.size());
        while(neverHeardAndSeen.size() != 0) {
            System.out.println(neverHeardAndSeen.poll());
        }
    }
}
