import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[] visited = new boolean[y + 1];
        
        q.offer(new int[] { x, 0 });
        visited[x] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int num = cur[0];
            int cnt = cur[1];
            
            if (num == y) {
                return cnt;
            }
            
            int[] nexts = { num + n, num * 2, num * 3 };
            
            for (int next : nexts) {
                if (next > y || visited[next])
                    continue;
                
                visited[next] = true;
                q.offer(new int[] { next, cnt + 1});
            }
        }
        
        return -1;
    }
}
