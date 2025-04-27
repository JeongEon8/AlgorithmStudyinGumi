import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		long n = Long.parseLong(split[0]);
		long m = Long.parseLong(split[1]);
		if ((n % (m + 1)) == 1) {
			System.out.println("Can't win");
		} else {
			System.out.println("Can win");
		}

	}

}
