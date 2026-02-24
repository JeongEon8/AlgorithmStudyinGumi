import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_1269 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int aN = Integer.parseInt(st.nextToken());
		int bN = Integer.parseInt(st.nextToken());
		HashSet<Integer> hashsetA = new HashSet<Integer>();
		HashSet<Integer> hashsetB = new HashSet<Integer>();
		int count = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < aN; i++) {
			hashsetA.add(Integer.parseInt(st.nextToken()));
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < bN; i++) {
			hashsetB.add(Integer.parseInt(st.nextToken()));
		}

		for (int key : hashsetB) {
			if (hashsetA.contains(key)) {
				count++;
			}
		}

		int result = hashsetA.size() + hashsetB.size() - 2 * count;
		System.out.println(result);
	}
}