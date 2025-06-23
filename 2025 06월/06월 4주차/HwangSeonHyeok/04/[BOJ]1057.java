import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		int n = Integer.parseInt(split[0]);
		int a = Integer.parseInt(split[1]);
		int b = Integer.parseInt(split[2]);
		int round = 0;
		while (a != b) {
			a = (a + 1) / 2;
			b = (b + 1) / 2;
			round++;
		}
		System.out.println(round);
	}

}