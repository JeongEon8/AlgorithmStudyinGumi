import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[] used = new int[1000000];
		int tryCnt = 0;
		for (int tc = 0; tc < n; tc++) {
			int g = Integer.parseInt(in.readLine());
			int[] students = new int[g];
			for (int i = 0; i < g; i++) {
				students[i] = Integer.parseInt(in.readLine());
			}
			for (int i = 1; i < 1000000; i++) {
				tryCnt++;
				boolean isAble = true;
				for (int student : students) {
					int mod = student % i;
					if (used[mod] == tryCnt) {
						isAble = false;
						break;
					}
					used[mod] = tryCnt;
				}
				if (isAble) {
					System.out.println(i);
					break;
				}
			}
		}

	}

}