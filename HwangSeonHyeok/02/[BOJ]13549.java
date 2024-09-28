import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	static int MAX_IDX = 100000;
	static boolean[] visited = new boolean[100001];
	static int[] dist = new int[100001];
	

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		int n = Integer.parseInt(split[0]);
		int k = Integer.parseInt(split[1]);
		Queue<Integer> q = new ArrayDeque<>();
		q.add(n);
		visited[n] = true;
		a:while(!q.isEmpty()) {
			int start = q.poll();
			int next;
			int tmp = start;
			while(tmp<=MAX_IDX/2) {
				next = tmp*2;
				if(!visited[next]) {
					dist[next] = dist[tmp];
					visited[next] = true;
					q.add(next);
					if(next==k) {
						break a;
					}
					tmp*=2;
				}else {
					break;
				}
			}
			next = start-1;
			if(next>=0&&!visited[next]) {
				dist[next] = dist[start]+1;
				visited[next] = true;
				q.add(next);
				if(next==k) {
					break a;
				}
			}
			next = start+1;
			if(next<=100000&&!visited[next]) {
				dist[next] = dist[start]+1;
				visited[next] = true;
				q.add(next);
				if(next==k) {
					break a;
				}
			}
			
		}
		System.out.println(dist[k]);
		
	}

}