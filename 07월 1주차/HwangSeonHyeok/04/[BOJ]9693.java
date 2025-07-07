import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[] arr = new int[1000001];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i <= 1000000; i++) {
			arr[i] = arr[i - 1];
			int tmp = i;
			while (tmp % 5 == 0) {
				arr[i]++;
				tmp /= 5;
			}
		}
		int caseNum = 1;
		while (true) {
			int n = Integer.parseInt(in.readLine());
			if (n == 0)
				break;
			sb.append("Case #").append(caseNum++).append(": ").append(arr[n]).append("\n");
		}
		System.out.println(sb);

	}

}