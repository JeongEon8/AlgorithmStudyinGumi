import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        Queue<Integer> q = new LinkedList<>();

        int N = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= N; i++) {
            q.add(i);
        }
        while(q.size() > 1) {
            q.poll();
            int second = q.poll();
            q.add(second);
        }
        System.out.println(q.poll());
    }
}
