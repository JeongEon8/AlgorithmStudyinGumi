import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static class Problem implements Comparable<Problem> {
		int num, score;

		public Problem(int num, int score) {
			super();
			this.num = num;
			this.score = score;
		}

		@Override
		public int compareTo(Problem o) {
			return o.score - this.score;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Problem[] pArr = new Problem[8];
		for (int i = 1; i <= 8; i++) {
			pArr[i - 1] = new Problem(i, Integer.parseInt(in.readLine()));
		}
		Arrays.sort(pArr);
		int sum = 0;
		int[] correct = new int[5];
		for (int i = 0; i < 5; i++) {
			sum += pArr[i].score;
			correct[i] = pArr[i].num;
		}
		Arrays.sort(correct);
		System.out.println(sum);
		for (int n : correct) {
			System.out.print(n + " ");
		}
	}

}