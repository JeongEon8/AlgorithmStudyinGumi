import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] claps = new int[m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < m; j++) {
				claps[j] += Integer.parseInt(st.nextToken());
			}
		}
		int a = Integer.parseInt(in.readLine());
		int idx = 0;
		int max = 0;
		int sum = 0;
		for (int i = 0; i < a; i++) {
			sum += claps[i];
		}
		max = sum;
		for (int i = 0; i < m - a; i++) {
			sum -= claps[i];
			sum += claps[i + a];
			if (max < sum) {
				max = sum;
			}
		}
		System.out.println(max);

	}

}