package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 나는야포켓몬마스터이다솜_1620 {
	static int N, M, number;
//	static String name;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// 이름 -> 번호 는 hashmap으로
		HashMap<String, Integer> nameToNum = new HashMap<>();
		// 번호 -> 이름은 배열으로
		String numToName[] = new String[N + 1];

		for (int i = 1; i <= N; i++) {
			String name = br.readLine();
			nameToNum.put(name, i);
			numToName[i] = name;
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < M; i++) {
			String string = br.readLine();

			if (Character.isDigit(string.charAt(0))) {
				int num = Integer.parseInt(string);
				sb.append(numToName[num]).append("\n");
			} else {
				sb.append(nameToNum.get(string)).append("\n");
			}
		}

		System.out.println(sb);
	}

}
