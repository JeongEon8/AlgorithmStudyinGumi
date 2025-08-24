import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Long n = Long.parseLong(in.readLine());
		List<Long> list = new ArrayList<>();
		for (long i = 2; i * i <= n; i++) {
			while (n % i == 0) {
				list.add(i);
				n /= i;
			}
		}
		if (n > 1)
			list.add(n);
		sb.append(list.size()).append("\n");
		for (long num : list) {
			sb.append(num).append(" ");
		}
		System.out.println(sb);

	}

}