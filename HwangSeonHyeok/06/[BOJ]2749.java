import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	static long mod = 1000000;

	static Map<Long, Long> m = new HashMap<>();

	static long fib(long n) {
		if (m.containsKey(n)) {
			return m.get(n);
		}
		if (n % 2 == 0) {
			m.put(n, (long) (Math.pow(fib(n / 2 + 1), 2) % mod - Math.pow(fib(n / 2 - 1), 2) % mod + mod) % mod);
			return m.get(n);
		} else {
			m.put(n, (long) (Math.pow(fib(n / 2 + 1), 2) % mod + Math.pow(fib(n / 2), 2) % mod) % mod);
			return m.get(n);
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		m.put(0l, 0l);
		m.put(1l, 1l);
		m.put(2l, 1l);
		long n = Long.parseLong(in.readLine());
		System.out.println(fib(n));
	}

}