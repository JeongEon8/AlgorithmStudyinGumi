import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_25709 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = 0;

		while (N != 0) {
			String strN = String.valueOf(N);
			if (strN.contains("1")) {
				int index = strN.indexOf('1');
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < strN.length(); i++) {
					if (i != index)
						sb.append(strN.charAt(i));
				}
				String resultStr = sb.toString().replaceFirst("^0+", "");
				N = resultStr.isEmpty() ? 0 : Integer.parseInt(resultStr);
			} else {
				N--;
			}
			count++;
		}

		System.out.println(count);
	}
}
