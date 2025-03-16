import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] strawberry = new String[16];
		for (int i = 0; i < 16; i++) {
			String str = "";
			for (int j = 0; j < 4; j++) {
				str += (i & 1 << (3 - j)) == 0 ? "V" : "딸기";
			}
			strawberry[i] = str;
		}
		int T = Integer.parseInt(in.readLine());
		for (int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(in.readLine());
			n--;
			n %= 28;
			n++;
			if (n > 15) {
				int num = 30 - n;
				sb.append(strawberry[num]).append('\n');

			} else {
				sb.append(strawberry[n]).append('\n');
			}
		}
		System.out.println(sb);

	}

}
