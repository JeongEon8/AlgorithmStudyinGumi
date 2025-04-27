import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            pQueue.add(Integer.valueOf(st.nextToken()));
        }
        StringBuilder sb = new StringBuilder("");

        while (pQueue.size() != 0) { 
            int item = pQueue.poll();
            sb.append(item);
            sb.append(" ");    
        }

        System.out.println(sb);
    }
}
