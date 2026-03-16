package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 숫자카드2 {
	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> map = new HashMap<>();
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			int have = Integer.parseInt(st.nextToken());

			if (map.containsKey(have)) {
				map.put(have, map.get(have) + 1);
			} else {
				map.put(have, 1);
			}
		}

		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < M; i++) {
			int check = Integer.parseInt(st.nextToken());
			if (map.get(check) == null) {
				sb.append("0" + " ");
			} else {
				sb.append(map.get(check) + " ");
			}
		}
		System.out.println(sb);

	}
}
