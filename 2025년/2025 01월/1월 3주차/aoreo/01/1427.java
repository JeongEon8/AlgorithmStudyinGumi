import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        
        int N = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());

        while(N > 0) {
            pQueue.add(N%10);
            N /= 10;
        }

        while(pQueue.size() != 0) {
            System.out.print(pQueue.poll());
        }
    }
}
