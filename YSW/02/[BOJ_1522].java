import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1522 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int aCount = 0;
		int bCurrentCount = 0;
		int result = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'a')
				aCount++;
		}

		for (int i = 0; i < aCount; i++) {
			if (s.charAt(i) == 'b')
				bCurrentCount++;
		}
		result = bCurrentCount;

		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i - 1) == 'b')
				bCurrentCount--;

			if (s.charAt((i + aCount - 1) % s.length()) == 'b')
				bCurrentCount++;

			if (result > bCurrentCount)
				result = bCurrentCount;
		}

		System.out.println(result);
	}
}




