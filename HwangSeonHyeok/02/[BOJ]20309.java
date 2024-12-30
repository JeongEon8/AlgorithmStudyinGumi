import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		String[] split = in.readLine().split(" ");
		boolean able = true;
		for (int i = 0; i < n; i++) {
			if (Integer.parseInt(split[i]) % 2 == i % 2) {
				able = false;
				break;
			}
		}
		if (able) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

	}

}