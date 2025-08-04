import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		HashMap<String, Double> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			String name = st.nextToken();
			double price = Double.parseDouble(st.nextToken());
			map.put(name, price * 1.05);
		}
		int ans = 0;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			String name = st.nextToken();
			double price = Double.parseDouble(st.nextToken());
			if (price > map.get(name))
				ans++;
		}
		System.out.println(ans);

	}

}