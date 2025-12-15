import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		HashMap<Integer, Integer> cards = new HashMap<>();
		String[] split = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(split[i]);
			cards.put(num, 0);
		}

		int M = Integer.parseInt(br.readLine());
		int[] nums = new int[M];

		split = br.readLine().split(" ");
		for (int i = 0; i < M; i++) {
			nums[i] = Integer.parseInt(split[i]);
			if (cards.containsKey(nums[i])) {
				System.out.print(1 + " ");
			} else {
				System.out.print(0 + " ");
			}
		}


	}

}