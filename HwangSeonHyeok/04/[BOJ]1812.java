import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		int oddSum = 0;
		int evenSum = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(in.readLine());
			if (i % 2 == 0) {
				oddSum += arr[i];
			} else {
				evenSum += arr[i];
			}
		}
		int current = (oddSum - evenSum) / 2;
		sb.append(current).append("\n");
		for (int i = 0; i < n - 1; i++) {
			current = arr[i] - current;
			sb.append(current).append("\n");
		}
		System.out.println(sb);

	}

}