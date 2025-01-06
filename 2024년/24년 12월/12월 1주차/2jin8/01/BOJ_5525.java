import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_5525 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		char[] chars = br.readLine().toCharArray();

		int ans = 0;
		int[] check = new int[M]; // OI가 나온 개수를 저장하는 배열
		// 처음이 OI로 시작하면 의미가 없으므로 i는 1부터 시작 
		for (int i = 1; i < M - 1; i++) {
			if (chars[i] == 'O' && chars[i + 1] == 'I')
				check[i + 1] = check[i - 1] + 1;

			// OI가 N번 이상 나왔고 시작 문자가 I라면 포함된 것
			// OI가 2번 > IOIOI (길이 5) => (i + 1) - (1 + 2 * N) - 1 = i - 2 * N + 1
			if (check[i + 1] >= N && chars[i - 2 * N + 1] == 'I')
				ans++;
		}
		System.out.println(ans);
	}
}
