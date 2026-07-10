import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        boolean[][] arr = new boolean[n + 1][n + 1];
        
        for(int[] wire : wires){
            arr[wire[0]][wire[1]] = true;
            arr[wire[1]][wire[0]] = true;
        }
        
        for(int[] wire : wires){
            arr[wire[0]][wire[1]] = false;
            arr[wire[1]][wire[0]] = false;
            int cnt = countNode(arr, n, wire[0]);
            int diff = Math.abs(n - cnt - cnt);
            
            answer = Math.min(answer, diff);
            
            arr[wire[0]][wire[1]] = true;
            arr[wire[1]][wire[0]] = true;
        }
        
        return answer;
    }
    
    public int countNode(boolean[][] arr, int n , int startNode){
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];
        queue.add(startNode);
        visited[startNode] = true;
        
        int count = 1;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int i = 0; i <= n; i++){
                if(arr[cur][i] && !visited[i]){
                    queue.add(i);
                    count++;
                    visited[i] = true;
                }
            }
        }
        
        return count;
    }
}
