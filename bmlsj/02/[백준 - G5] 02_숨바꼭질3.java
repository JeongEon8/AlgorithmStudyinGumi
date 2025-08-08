import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static boolean[] visited;
    
    public static void main(String[] args) throws Exception {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        K = Integer.parseInt(split[1]);
        
        visited = new boolean[200001];
        System.out.println(bfs());
    }
    
    static int bfs() {
    	
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{N, 0});
        visited[N] = true;
        
        while (!dq.isEmpty()) {
        	
            int[] cur = dq.pollFirst();
            int x = cur[0];
            int time = cur[1];
            
            if (x == K) return time;
            
            // 순간이동
            int nx = x * 2;
            if (nx <= 200000 && !visited[nx]) {
                visited[nx] = true;
                dq.addFirst(new int[]{nx, time});
            }
            
            // -1, +1 이동
            for (int dir : new int[]{-1, 1}) {
                nx = x + dir;
                if (nx >= 0 && nx <= 200000 && !visited[nx]) {
                    visited[nx] = true;
                    dq.addLast(new int[]{nx, time + 1});
                }
            }
        }
        return -1;
    }
}
