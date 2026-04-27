import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_23304 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println(isAkarakaPalindrome(br.readLine()) ? "AKARAKA" : "IPSELENTI");
	}

	public static boolean isAkarakaPalindrome(String input) {
		int len = input.length();

		if (len == 1) {
			return true;
		}

		boolean result = false;
		if (len >= 2) {

			for (int i = 0; i < len / 2; i++) {
				if (input.charAt(i) != input.charAt(len - 1 - i)) {
					return false;
				}
			}

			String prefix = input.substring(0, len / 2);
			String suffix = input.substring(len / 2 + (len % 2 == 0 ? 0 : 1), len);

			if (isAkarakaPalindrome(prefix) && isAkarakaPalindrome(suffix)) {
				result = true;
			}
		}

		return result;
	}
}