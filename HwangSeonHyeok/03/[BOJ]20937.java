import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		String[] split = in.readLine().split(" ");
		int[] arr = new int[50001];
		for (int i = 0; i < n; i++) {
			arr[Integer.parseInt(split[i])]++;
		}
		int max = 0;
		for (int i = 1; i <= 50000; i++) {
			max = Math.max(max, arr[i]);
		}
		System.out.println(max);

	}

}
