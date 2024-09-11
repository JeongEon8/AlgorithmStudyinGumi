import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[] existCard = new int[1000001];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(in.readLine());
		String[] split = in.readLine().split(" ");
		int[] cardArr = new int[n];
		int[] score = new int[n];
		int max = 0;
		for (int i = 0; i < n; i++) {
			cardArr[i] = Integer.parseInt(split[i]);
			existCard[cardArr[i]] = i + 1;
			if (max < cardArr[i]) {
				max = cardArr[i];
			}
		}
		for (int i = 0; i < n; i++) {
			int current = cardArr[i] * 2;
			while (current <= max) {
				if (existCard[current] > 0) {
					score[existCard[current] - 1]--;
					score[i]++;
				}
				current += cardArr[i];
			}
		}
		for (int s : score) {
			sb.append(s + " ");
		}
		System.out.println(sb);
	}
}