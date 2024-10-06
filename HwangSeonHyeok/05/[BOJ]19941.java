import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		String[] split = in.readLine().split(" ");
		int n = Integer.parseInt(split[0]);
		int m = Integer.parseInt(split[1]);
		int[][] dist = new int[n][n];
		for(int i = 0; i<n;i++) {
			split = in.readLine().split(" ");
			for(int j = 0; j<n;j++) {
				dist[i][j] = Integer.parseInt(split[j]);
			}
		}
		for(int mid = 0; mid<n;mid++) {
			for(int start = 0; start<n;start++){
				if(start==mid)continue;
				for(int end = 0; end<n;end++) {
					if(start==end||mid==end) continue;
					dist[start][end] = Math.min(dist[start][end],dist[start][mid]+dist[mid][end]);
				}
			}
		}
		for(int i = 0; i<m;i++) {
			split = in.readLine().split(" ");
			int start = Integer.parseInt(split[0])-1;
			int end = Integer.parseInt(split[1])-1;
			int t = Integer.parseInt(split[2]);
			if(dist[start][end]<=t) {
				sb.append("Enjoy other party\n");
			}else {
				sb.append("Stay here\n");
			}
		}
		System.out.println(sb);
		
	}

}