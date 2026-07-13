import java.util.*;

class Solution {
    
    class Info {
        int count;
        int total;
        Info(int count, int total) {
            this.count = count;
            this.total = total;
        }
    }
    
    public int solution(int x, int y, int n) {
        if (x == y) return 0;
        
        Queue<Info> que = new ArrayDeque<>();
        boolean[] visited = new boolean[y + 1];
        
        que.add(new Info(0, x));
        visited[x] = true;
        
        while (!que.isEmpty()) {
            Info info = que.poll();
            int nTotal = info.total;
            int nCount = info.count;
            
            int[] nextMoves = {nTotal + n, nTotal * 2, nTotal * 3};
            
            for (int next : nextMoves) {
                if (next == y) {
                    return nCount + 1;
                }
                
                if (next < y && !visited[next]) {
                    visited[next] = true;
                    que.add(new Info(nCount + 1, next));
                }
            }
        }
        
        return -1;
    }
}
