import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		int n = Math.min(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
		int m = Math.max(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
		int t = Integer.parseInt(split[2]);
		int burger = 0;
		int colar = Integer.MAX_VALUE;
		int cnt = 0;
		while (t > 0) {
			int tmpBurger = cnt + t / n;
			int tmpcolar = t % n;
			if (tmpcolar < colar) {
				colar = tmpcolar;
				burger = tmpBurger;
			}
			if (colar == 0)
				break;
			t -= m;
			cnt++;
		}
		System.out.println(burger + " " + colar);

	}

}