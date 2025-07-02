import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(in.readLine());
		List<Integer> sequence = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			sequence.add(i * 2 - 1);
		}
		for (int num : sequence) {
			sb.append(num).append(" ");
		}
		System.out.println(sb);

	}

}