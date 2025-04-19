import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(in.readLine());
		String[] query = in.readLine().split("\\*");
		int prelength = query[0].length();
		int postlength = query[1].length();
		for (int i = 0; i < n; i++) {
			boolean isDA = false;
			String text = in.readLine();
			if (text.length() >= prelength + postlength) {
				String pre = text.substring(0, prelength);
				String post = text.substring(text.length() - postlength);
				if (pre.equals(query[0]) && post.equals(query[1])) {
					isDA = true;
				}

			}
			if (isDA) {
				sb.append("DA\n");
			} else {
				sb.append("NE\n");
			}

		}
		System.out.println(sb);
	}

}
