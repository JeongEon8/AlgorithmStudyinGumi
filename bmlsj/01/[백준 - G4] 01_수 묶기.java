import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		List<Integer> positive = new ArrayList<Integer>();
		List<Integer> negative = new ArrayList<Integer>();

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());

			if (num <= 0)
				negative.add(num);
			else
				positive.add(num);
		}

		Collections.sort(positive, Collections.reverseOrder());
		Collections.sort(negative);

		int sum = 0;
		for (int i = 0; i < positive.size() - 1; i += 2) {
			if (positive.get(i) + positive.get(i + 1) >= positive.get(i) * positive.get(i + 1)) {
				sum += positive.get(i) + positive.get(i + 1);
			} else {
				sum += positive.get(i) * positive.get(i + 1);
			}
		}

		for (int i = 0; i < negative.size() - 1; i += 2) {
			if (negative.get(i) + negative.get(i + 1) >= negative.get(i) * negative.get(i + 1)) {
				sum += negative.get(i) + negative.get(i + 1);
			} else {
				sum += negative.get(i) * negative.get(i + 1);
			}
		}
		
		if (positive.size() % 2 == 1)
			sum += positive.get(positive.size() - 1);
		if (negative.size() % 2 == 1)
			sum += negative.get(negative.size() - 1);
		System.out.println(sum);

	}

}