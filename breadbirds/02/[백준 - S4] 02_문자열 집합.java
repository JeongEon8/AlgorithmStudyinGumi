package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

import java.util.HashSet;
import java.util.StringTokenizer;

public class 문자열집합_14425 {
	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		HashSet<String> s = new HashSet<>();
		for (int i = 0; i < N; i++) {
			s.add(br.readLine());
		}

		int cnt = 0;

		for (int i = 0; i < M; i++) {
			if (s.contains(br.readLine()))
				cnt++;
		}

		System.out.println(cnt);

	}

}
