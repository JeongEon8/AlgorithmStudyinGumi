import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] split = br.readLine().split(" ");
		int N = Integer.parseInt(split[0]);
		int L = Integer.parseInt(split[1]);

		int[][] pools = new int[N][2];
		for (int t = 0; t < N; t++) {
			split = br.readLine().split(" ");
			int st = Integer.parseInt(split[0]);
			int ed = Integer.parseInt(split[1]);

			pools[t][0] = st;
			pools[t][1] = ed;
		}
		
		Arrays.sort(pools, (a, b) -> a[0] - b[0]);
		int endPos = 0;
		int ans = 0;
		
		for(int[] p: pools) {
			int start = p[0];
			int end = p[1];
			
			// 이미 덮인 구간
			if (start < endPos) start = endPos;
			
			int len = end - start;
			int count = (len + L - 1) / L;
			ans += count;
			
			endPos = start + count * L;
			
		}
		
		System.out.println(ans);

	}

}