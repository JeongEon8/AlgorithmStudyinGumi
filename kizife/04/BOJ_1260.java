
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][] arr;
	static boolean[] visit;
	static int N;
	static int M;
	static int V;
	

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();
		
		arr = new int[N+1][N+1];
		
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		
		visit = new boolean[N+1];
		dfs(V);
		
		System.out.println();
		
		visit = new boolean[N+1];
		bfs(V);
		
		System.out.println();
	}


	static void bfs(int V) {
		// TODO Auto-generated method stub
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(V);
		visit[V] = true;
		
		System.out.print(V + " ");
		
		while(!queue.isEmpty()) {
			int n = queue.poll();
			
			for (int i = 1; i < arr.length; i++) {
				if(arr[n][i] == 1 && visit[i] == false) {
					visit[i] = true;
					System.out.print(i + " ");
					queue.offer(i);
				}
			}
		}
	}


	static void dfs(int V) {
		// TODO Auto-generated method stub
		visit[V] = true;
		System.out.print(V + " ");
		
		if(V == arr.length) return;
		for (int i = 1; i <arr.length; i++) {
			if(arr[V][i] == 1 && visit[i] == false) {
				dfs(i);
			}
		}
	}
	
	
	

}
