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
		int t = Integer.parseInt(st.nextToken());
		List<Integer> list = new ArrayList<>();
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		List<Integer> sortedList = list.subList(0, t);
		Collections.sort(sortedList);
		StringBuilder sb = new StringBuilder();
		for (int num : sortedList) {
			sb.append(num).append(" ");
		}
		for (int i = t; i < n; i++) {
			sb.append(list.get(i)).append(" ");
		}
		System.out.println(sb);

	}

}