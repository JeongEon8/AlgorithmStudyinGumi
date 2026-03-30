package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class 회사에있는사람_7785 {
	static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		HashSet<String> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String status = st.nextToken();

			if (status.equals("enter")) {
				set.add(name);
			} else {
				set.remove(name);
			}
		}

		List<String> list = new ArrayList<>(set);
		Collections.sort(list, Collections.reverseOrder());

		for (String name : list) {
			System.out.println(name);
		}
	}

}
