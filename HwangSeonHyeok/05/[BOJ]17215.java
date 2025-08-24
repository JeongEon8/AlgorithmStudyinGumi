import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		List<Integer> scores = new ArrayList<>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == 'S') {
				scores.add(10);
			} else if (c == 'P') {
				scores.add(10 - scores.get(scores.size() - 1));
			} else if (c == '-') {
				scores.add(0);
			} else {
				scores.add(c - '0');
			}
		}
		int ans = 0;
		int frame = 1;
		int scoreIndex = 0;

		while (frame <= 10) {
			int first = scores.get(scoreIndex);
			if (first == 10) {
				ans += 10 + scores.get(scoreIndex + 1) + scores.get(scoreIndex + 2);
				scoreIndex++;
			} else {
				int second = scores.get(scoreIndex + 1);
				if (first + second == 10) {
					ans += 10 + scores.get(scoreIndex + 2);
				} else {
					ans += first + second;
				}
				scoreIndex += 2;
			}

			if (frame < 10) {
				frame++;
			} else {
				break;
			}
		}

		System.out.println(ans);

	}

}