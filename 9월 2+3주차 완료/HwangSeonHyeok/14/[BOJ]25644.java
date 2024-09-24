import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		String[] split = in.readLine().split(" ");
		int min = Integer.parseInt(split[0]);
		int[] benefit = new int[n];
		for (int i = 1; i < n; i++) {
			int stock = Integer.parseInt(split[i]);
			if (min > stock) {
				min = stock;
			}
			benefit[i] = Math.max(benefit[i - 1], stock - min);
		}
		System.out.println(benefit[n - 1]);
	}
}