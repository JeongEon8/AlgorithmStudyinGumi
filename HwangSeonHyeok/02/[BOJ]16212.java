import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		long w = 0;
		long h = 0;
		for (int i = 0; i < n; i++) {
			String[] split = in.readLine().split(" ");
			int a = Integer.parseInt(split[0]);
			int b = Integer.parseInt(split[1]);
			w = Math.max(w, Math.max(a, b));
			h = Math.max(h, Math.min(a, b));
		}
		System.out.println(w * h);
	}

}
