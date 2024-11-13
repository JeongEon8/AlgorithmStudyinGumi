import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		String binary = Integer.toString(n+1, 2);
		String ans = "";
		for (int i = 1; i < binary.length(); i++) {
			if (binary.charAt(i) == '0') {
				ans += "4";
			} else {
				ans += "7";
			}
		}
		System.out.println(ans);

	}

}