import java.util.*;
class Solution {
    
    public int solution(int x, int y, int n) {

        // x -> y
        int answer = calc(x, y, n);
        return answer;
    }
    static int calc(int x, int y, int n) {
        
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[1000001];
        
        q.offer(new int[]{x, 0});
        visited[x] = true;
        

         while (!q.isEmpty()) {

            int[] cur = q.poll();

            int num = cur[0];
            int cnt = cur[1];
             
             if (num == y) {
                 return cnt;
             }
             
             int[] next = {num + n, num * 2, num * 3};
             
             for(int nx: next) {
                 if (nx <= y && !visited[nx]) {
                     visited[nx] = true;
                     q.offer(new int[]{nx, cnt + 1});
                 }
             }
             
         }
        
        return -1;
    }
}