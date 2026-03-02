package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 다리놓기_1010 {
	static int N, M;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			System.out.println(nCr(M, N));
			
		}
	}
	private static long nCr(int n, int r) {
		r = Math.min(r, n-r);
		long result = 1;
		
		for(int i = 1; i <= r; i++) {
			result = result * (n-r + i)/i;
		}
		return result;
		
	}

}
