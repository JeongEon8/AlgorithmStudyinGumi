package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Baekjoon1766 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] input = in.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

       
        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        int[] indegree = new int[N + 1];
        
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

      
        for (int m = 0; m < M; m++) {
            input = in.readLine().split(" ");
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);

            
            graph[A].add(B);
            indegree[B]++;
        }

       
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                queue.offer(i); 
            }
        }

        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current);
            System.out.print(" ");

            for (int next : graph[current]) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next); 
                }
            }
        }

        
    }
}
