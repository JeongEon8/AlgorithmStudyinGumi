import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String pika = in.readLine();
		boolean isable = true;
		for (int i = 0; i < pika.length(); i++) {
			if (i == pika.length() - 1) {
				isable = false;
				break;
			}
			if (pika.charAt(i) == 'p') {
				if (!"pi".equals(pika.substring(i, i + 2))) {
					isable = false;
					break;
				}
				i += 1;
			} else if (pika.charAt(i) == 'k') {
				if (!"ka".equals(pika.substring(i, i + 2))) {
					isable = false;
					break;
				}
				i += 1;
			} else if (i < pika.length() - 2 && pika.charAt(i) == 'c') {
				if (!"chu".equals(pika.substring(i, i + 3))) {
					isable = false;
					break;
				}
				i += 2;
			} else {
				isable = false;
				break;
			}
		}

		if (isable) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

}