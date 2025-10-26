import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int[] sumArr = new int[n * 2 + 1];
		int idx = 0;
		for (int num : arr) {
			while (idx < num + n) {
				sumArr[++idx] = sumArr[idx - 1];
			}
			sumArr[idx]++;
		}
		while (idx < n * 2) {
			sumArr[++idx] = sumArr[idx - 1];
		}
		List<Integer> ansList = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			int moreCnt = sumArr[2 * n] - sumArr[n + i];
			int lessCnt = sumArr[n] - sumArr[n - i];
			if (moreCnt + lessCnt == i) {
				ansList.add(i);
			}
		}
		System.out.println(ansList.size());
		StringBuilder sb = new StringBuilder();
		for (int ans : ansList) {
			sb.append(ans).append(' ');
		}
		System.out.println(sb);

	}

}