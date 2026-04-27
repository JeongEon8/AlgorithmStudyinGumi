import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_33985 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String input = br.readLine();
		if (input.charAt(input.length() - 1) == 'A'||input.charAt(0) == 'B') {
			System.out.println("No");
		} else {
			System.out.println("Yes");
		}
	}
}