import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15719 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < arr.length; i++) {
			int currentNum = Integer.parseInt(st.nextToken());
			arr[currentNum]++;
			if (arr[currentNum] > 1) {
				System.out.println(currentNum);
				return;
			}
		}
	}
}
