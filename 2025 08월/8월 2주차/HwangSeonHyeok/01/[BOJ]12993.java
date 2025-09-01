import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		boolean isAble = true;
		while (isAble && (x > 0 || y > 0)) {
			int remainX = x % 3;
			int remainY = y % 3;
			if (remainX + remainY == 1) {
				x /= 3;
				y /= 3;
			} else {
				isAble = false;
			}
		}
		if (isAble) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}

	}

}