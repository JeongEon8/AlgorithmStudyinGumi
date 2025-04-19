import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		long k = Integer.parseInt(in.readLine());
		String[] split = in.readLine().split(" ");
		long a = Long.parseLong(split[0]);
		long b = Long.parseLong(split[1]);
		long c = Long.parseLong(split[2]);
		long d = Long.parseLong(split[3]);
		long ans1 = a * k + b;
		long ans2 = c * k + d;
		if (ans1 == ans2) {
			System.out.println("Yes " + ans1);
		} else {
			System.out.println("No");
		}

	}

}
