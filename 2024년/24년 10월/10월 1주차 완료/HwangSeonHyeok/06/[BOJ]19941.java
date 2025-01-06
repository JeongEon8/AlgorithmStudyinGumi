import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	static class Edge implements Comparable<Edge>{
		int a,b;
		long cost;

		public Edge(int a, int b, long cost) {
			super();
			this.a = a;
			this.b = b;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return (int)(this.cost-o.cost);
		}	
	}
	
	static int[] parents;
	static int findParents(int idx) {
		if(parents[idx]==idx) {
			return idx;
		}
		return parents[idx] = findParents(parents[idx]);
	}
	static boolean setGroup(int a, int b) {
		int aRoot = findParents(parents[a]);
		int bRoot = findParents(parents[b]);
		if(aRoot==bRoot) {
			return false;
		}else {
			parents[bRoot] = aRoot;
			return true;
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		parents = new int[n];
		for(int i = 0; i<n;i++) {
			String[] split = in.readLine().split(" ");
			parents[i] = i;
			for(int j = i+1; j<n; j++) {
				pq.add(new Edge(i,j,Integer.parseInt(split[j])));
			}
		}
		long ans = 0;
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			if(setGroup(e.a,e.b)) {
				ans+=e.cost;
			}
		}
		System.out.println(ans);
	}

}