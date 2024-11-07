import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static class Ranker implements Comparable<Ranker> {
		String name;
		int score, isHidden;

		public Ranker(String name, int score, int isHidden) {
			super();
			this.name = name;
			this.score = score;
			this.isHidden = isHidden;
		}

		@Override
		public int compareTo(Ranker o) {
			if (this.score == o.score) {
				return this.name.compareTo(o.name);
			}
			return o.score - this.score;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(in.readLine());
		Ranker[] ranking = new Ranker[n];
		for (int i = 0; i < n; i++) {
			String[] split = in.readLine().split("\"");
			String name = split[3];
			String scoreStr = "";
			for (int j = 1; j < split[6].length(); j++) {
				if (split[6].charAt(j) != ',') {
					scoreStr += split[6].charAt(j);
				}
			}
			int score = Integer.parseInt(scoreStr);
			int isHidden = split[8].charAt(1) - '0';
			ranking[i] = new Ranker(name, score, isHidden);
		}
		Arrays.sort(ranking);
		int currentRanking = 1;
		if (ranking[0].isHidden == 0)
			sb.append("1 " + ranking[0].name + " " + ranking[0].score + "\n");
		for (int i = 1; i < n; i++) {
			if (ranking[i].score < ranking[i - 1].score) {
				currentRanking = i + 1;
			}
			if (ranking[i].isHidden == 0) {
				sb.append(currentRanking + " " + ranking[i].name + " " + ranking[i].score + "\n");
			}
		}
		System.out.println(sb);

	}

}