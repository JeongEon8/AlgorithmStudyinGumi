import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        Queue<Integer[]> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[y + 1];
        queue.add(new Integer[] {x, 0});
        visited[x] = true;
        
        while(!queue.isEmpty()){
            Integer[] cur = queue.poll();
            
            if(cur[0] == y){
                return cur[1];
            }
            
            if(cur[0] + n <= y && !visited[cur[0] + n]){
                queue.add(new Integer[] {cur[0] + n, cur[1] + 1});
                visited[cur[0] + n] = true;
            }
            if(cur[0] * 2 <= y && !visited[cur[0] * 2]){
                queue.add(new Integer[] {cur[0] * 2, cur[1] + 1});
                visited[cur[0] * 2] = true;
            }
            if(cur[0] * 3 <= y && !visited[cur[0] * 3]){
                queue.add(new Integer[] {cur[0] * 3, cur[1] + 1});
                visited[cur[0] * 3] = true;
            }
        }
        
        return -1;
    }
}
