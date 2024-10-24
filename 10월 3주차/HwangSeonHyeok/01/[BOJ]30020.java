import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		String[] split = in.readLine().split(" ");
		int a = Integer.parseInt(split[0]);
		int b = Integer.parseInt(split[1]);
		if (a > b && a <= b * 2) {
			sb.append("YES\n");
			sb.append(a - b + "\n");
			while (a - b != 1) {
				a -= 2;
				b -= 1;
				sb.append("aba\n");
			}
			sb.append("a");
			for (int i = 0; i < b; i++) {
				sb.append("ba");
			}
		} else {
			sb.append("NO");
		}
		System.out.println(sb);

	}

}