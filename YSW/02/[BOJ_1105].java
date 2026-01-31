import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1105 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String L = st.nextToken();
		String R = st.nextToken();
		int min = 0;

		if (L.length() != R.length()) {
			System.out.println(min);
			return;
		} else {
			for (int i = 0; i < L.length(); i++) {
				if (L.charAt(i) == R.charAt(i)) {
					if (L.charAt(i) == '8') {
						min++;
					}
				} else {
					break;
				}
			}

			System.out.println(min);
		}
	}
}