import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        int M = Integer.parseInt(st.nextToken());
        
        List<Integer>[] computers = new ArrayList[N+1];
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N+1];
        int answer = 0;

        for (int i = 0; i < N+1; i++) {
            computers[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int pairA = Integer.parseInt(st.nextToken());
            int pairB = Integer.parseInt(st.nextToken());

            computers[pairA].add(pairB);
            computers[pairB].add(pairA);
        }
        q.add(1);
        visited[1] = true;

        while(q.size() > 0) {
            int cur = q.poll();
            for(int con: computers[cur]) {
                if(visited[con] == false) {
                    answer++;
                    visited[con] = true;
                    q.add(con);
                }
            }
        }
        System.out.println(answer);
    }
}
