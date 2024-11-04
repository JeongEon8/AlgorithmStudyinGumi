package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Baekjoon2252 {

	public static void main(String[] args)throws Exception {
		
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] input = in.readLine().split(" ");
		int N = Integer.parseInt(input[0]); 
		int M = Integer.parseInt(input[1]);
		ArrayList<Integer>[] arr = new ArrayList[N+1];
		for(int n = 0; n<=N; n++) {
			arr[n] = new ArrayList<Integer>();
		}
		int[] indegree = new int[N + 1];
		
		for(int m = 0; m<M; m++) {
			input = in.readLine().split(" ");
			int A = Integer.parseInt(input[0]); 
			int B = Integer.parseInt(input[1]);
			
			arr[A].add(B);
			indegree[B]++;
		}
		
		// 우선순위 큐 사용
        Queue<Integer> queue = new ArrayDeque();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                queue.offer(i); // 진입 차수가 0인 문제를 큐에 추가
            }
        }
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current);
            System.out.print(" ");

            for (int next : arr[current]) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next); // 진입 차수가 0이 된 문제를 큐에 추가
                }
            }
        }
		
		
	}

}
