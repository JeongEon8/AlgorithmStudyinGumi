import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= a; i++) {
			if (30 % (i + 1) == 0) {
				sb.append(i).append('\n');
			}
		}
		System.out.println(sb);

	}

}