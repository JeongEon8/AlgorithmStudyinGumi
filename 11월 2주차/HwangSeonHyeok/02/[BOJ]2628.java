import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		List<Integer> columns = new ArrayList<>();
		List<Integer> rows = new ArrayList<>();
		columns.add(0);
		columns.add(n);
		rows.add(0);
		rows.add(m);
		int t = Integer.parseInt(in.readLine());
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(in.readLine());
			int type = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			if (type == 0) {
				rows.add(num);
			} else {
				columns.add(num);
			}
		}
		Collections.sort(rows);
		Collections.sort(columns);
		int ans = 0;
		for (int i = 1; i < rows.size(); i++) {
			int rowLength = rows.get(i) - rows.get(i - 1);
			for (int j = 1; j < columns.size(); j++) {
				int columnLength = columns.get(j) - columns.get(j - 1);
				ans = Math.max(ans, columnLength * rowLength);
			}
		}
		System.out.println(ans);

	}

}