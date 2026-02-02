import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int low = 1, high = 10;

		while (true) {

			int num = Integer.parseInt(br.readLine());
			if (num == 0)
				break;
			String stan = br.readLine();

			if (stan.equals("too high")) {
				high = Math.min(high, num - 1);
			} else if (stan.equals("too low")) {
				low = Math.max(low, num + 1);
			} else if (stan.equals("right on")) {
				if (low > num || high < num) {
					System.out.println("Stan is dishonest");
				} else {
					System.out.println("Stan may be honest");
				}
				low = 1;
				high = 10;
			}
		}

	}

}