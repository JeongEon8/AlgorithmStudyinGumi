import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		String binary = Integer.toBinaryString(n);
		int chocolate = (int) Math.pow(2, binary.length());
		int cnt = 0;
		if (chocolate / n == 2) {
			chocolate /= 2;
		} else {
			for (int i = binary.length(); i >= 0; i--) {
				if (binary.charAt(i - 1) == '1') {
					cnt += i;
					break;
				}
			}
		}
		System.out.println(chocolate + " " + cnt);
	}
}
