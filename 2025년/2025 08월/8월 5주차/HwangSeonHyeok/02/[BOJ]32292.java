import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(in.readLine());
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(in.readLine());
			String str = in.readLine();
			StringBuilder tmp = new StringBuilder();
			for (int j = 0; j < str.length(); j++) {
				char c = str.charAt(j);
				tmp.append(c);
				int idx = 0;
				while (true) {
					int abbIdx = tmp.indexOf("ABB", idx);
					if (abbIdx == -1) {
						break;
					}
					tmp.replace(abbIdx, abbIdx + 3, "BA");
					idx = Math.max(0, abbIdx - 2);
				}
			}
			sb.append(tmp).append("\n");
		}
		System.out.println(sb);

	}

}