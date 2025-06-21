package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Baekjoon1005 {
	

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
		// 테스트케이스의 개수
		int T = Integer.parseInt(in.readLine());
		
		// 테스트 케이스 만큼 반
		for ( int t = 0; t < T; t++) {
			
			String input[] = in.readLine().split(" ");
			
			// 건물의 개수 N
			int N = Integer.parseInt(input[0]);
			
			// 건물 건설까지 걸리는 총 시간 저장하는 공간
			int[] total = new int[N+1];
			
			// 건설순서 규칙의 총 개수 K
			int K = Integer.parseInt(input[1]);
			
			int[] degree = new int[N+1];
			
			// 주문 순서 저장하는 공간
			List<Integer>[] order = new ArrayList[N + 1];
			
		
			
			for (int n = 0; n < N+1; n++) {
			    order[n] = new ArrayList();
			}
			
			
			input = in.readLine().split(" ");
			
			// 건물당 건설에 걸리는 시간
			int[] D = new int[N+1];
			for (int i = 1; i <= N; i++) {
                D[i] = Integer.parseInt(input[i - 1]);
                total[i] = D[i];  // 초기값: 자기 자신의 건설 시간
            }
			
			// 규칙 수만큼 반복
			for(int k = 0; k< K; k++) {
				input = in.readLine().split(" ");
				int a = Integer.parseInt(input[0]);
				int b = Integer.parseInt(input[1]);
				
				order[a].add(b);
				degree[b]++;
				
			}
			
			
			Queue<Integer> que = new ArrayDeque();
			for(int n =0; n<N+1; n++) {
				if(degree[n]==0) {
					que.add(n);
				}
			}
			
			 while(!que.isEmpty()) {
				int test = que.poll();
				
				
				for (int num : order[test]) {
					
					total[num] = Math.max(total[num], total[test] + D[num]);
                    degree[num]--;
					if(degree[num]==0) {
						que.add(num);
					}
				}
				
					
				
				
			}
			int W = Integer.parseInt(in.readLine());
			System.out.println(total[W]);
			
		}
		
		
		
		

	}

}
