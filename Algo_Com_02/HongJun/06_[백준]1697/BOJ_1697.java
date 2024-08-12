import java.util.*;
import java.io.*;

public class BOJ_1697 {
	private static int N, K;
	Queue<Integer> q;
	private static int[] node;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] line = in.readLine().split(" ");
		N = Integer.parseInt(line[0]);
		K = Integer.parseInt(line[1]);
		
		node = new int[(int) Math.pow(10, 5)+1];
		
		bfs(N);

	}

	private static void bfs(int n) {
		
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(n);
		
		while (!q.isEmpty()) {
			
			int x = q.poll();
			
			// 동생 위치에 도달하면 종료
			if (x == K) {
				System.out.println(node[x]);
				break;
			}
			// 다음 이동할 위치는 X-1, X+1, 2*X
			int[] nextNode = {x-1, x+1, x*2};
			for (int i : nextNode) {
				if (0 <= i && i <= (int) Math.pow(10, 5) && node[i] == 0) {
					q.offer(i);
					node[i] = node[x]+1;
				}
			}
		}

	}

}