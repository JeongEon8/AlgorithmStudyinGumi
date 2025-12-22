import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		List<BigInteger> ans = new ArrayList<>();
		int n = Integer.parseInt(in.readLine());
		for (int i = 0; i < n; i++) {
			String[] str = in.readLine().split("\\D+");
			for (String numStr : str) {
				if (!numStr.isEmpty()) {
					ans.add(new BigInteger(numStr));
				}
			}

		}
		Collections.sort(ans);
		StringBuilder sb = new StringBuilder();
		for (BigInteger ansNum : ans) {
			sb.append(ansNum).append('\n');
		}
		System.out.println(sb);

	}

}