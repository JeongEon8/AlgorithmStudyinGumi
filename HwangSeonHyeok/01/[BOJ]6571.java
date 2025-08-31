import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		List<BigInteger> fibo = new ArrayList<BigInteger>();
		BigInteger max = new BigInteger("1" + "0".repeat(100));
		BigInteger zero = new BigInteger("0");
		fibo.add(new BigInteger("1"));
		fibo.add(new BigInteger("2"));
		int n = 2;
		while (true) {
			BigInteger f1 = fibo.get(n - 1);
			BigInteger f2 = fibo.get(n - 2);
			fibo.add(f1.add(f2));
			if (fibo.get(n).compareTo(max) > 0) {
				break;
			}
			n++;
		}
		while (true) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			BigInteger a = new BigInteger(st.nextToken());
			BigInteger b = new BigInteger(st.nextToken());
			if (a.equals(BigInteger.ZERO) && b.equals(BigInteger.ZERO)) {
				break;
			}
			int cnt = 0;
			for (BigInteger f : fibo) {
				if (a.compareTo(f) <= 0 && b.compareTo(f) >= 0) {
					cnt++;
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);

	}

}