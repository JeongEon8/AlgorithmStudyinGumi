import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int mid = n / 2;
		int[] candidate = new int[n];
		for (int i = 0; i < n; i++) {
			int[] cows = new int[n];
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < n; j++) {
				cows[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(cows);
			candidate[i] = cows[mid];
		}
		Arrays.sort(candidate);
		System.out.println(candidate[mid]);
	}

}