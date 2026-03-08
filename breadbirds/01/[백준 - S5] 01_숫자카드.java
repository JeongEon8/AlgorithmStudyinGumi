package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 숫자카드_10815_hashset으로 {
	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		HashSet<Integer> have = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			have.add(Integer.parseInt(st.nextToken()));
		}
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < M; i++) {
			int x = Integer.parseInt(st.nextToken());

			if (have.contains(x))
				sb.append("1 ");
			else
				sb.append("0 ");
		}

		System.out.println(sb);
	}

}
