import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int getClockNum(int a, int b, int c, int d) {
		int num1 = a * 1000 + b * 100 + c * 10 + d;
		int num2 = b * 1000 + c * 100 + d * 10 + a;
		int num3 = c * 1000 + d * 100 + a * 10 + b;
		int num4 = d * 1000 + a * 100 + b * 10 + c;
		return Math.min(num1, Math.min(num2, Math.min(num3, num4)));
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		int a = Integer.parseInt(split[0]);
		int b = Integer.parseInt(split[1]);
		int c = Integer.parseInt(split[2]);
		int d = Integer.parseInt(split[3]);
		int clock = getClockNum(a, b, c, d);
		int ans = 0;
		for (int i = 1111; i <= clock; i++) {
			int a2 = i / 1000;
			int b2 = (i / 100) % 10;
			int c2 = (i / 10) % 10;
			int d2 = i % 10;
			if (a2 == 0 || b2 == 0 || c2 == 0 || d2 == 0)
				continue;
			if (i == getClockNum(a2, b2, c2, d2)) {
				ans++;
			}
		}
		System.out.println(ans);

	}

}