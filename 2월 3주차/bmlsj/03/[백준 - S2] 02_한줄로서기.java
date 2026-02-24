import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int N, M;
	static int[] people;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		people = new int[N];
		TreeMap<Integer, Integer> map = new TreeMap<>((o1, o2) -> o2 - o1);

		String[] split = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			map.put(i + 1, Integer.parseInt(split[i]));
		}


		Stack<Integer> st = new Stack<>();
		for (int idx : map.keySet()) {

			Stack<Integer> tmp = new Stack<>();
			int tallerFrontOfMe = map.get(idx); // 앞쪽에 나보다 큰 사람 수
			int cnt = 0;

			for (int num : st) {
				if (num > idx) { // 나보다 큰 수
					cnt++;
				}
			}

			if (cnt == tallerFrontOfMe) {
				st.add(idx);
			} else {
				while (cnt > tallerFrontOfMe) {
					cnt--;
					tmp.add(st.pop());
				}

				st.add(idx);
				while (!tmp.isEmpty()) {
					st.add(tmp.pop());
				}
			}
		}
		
		for(int num: st) {
			System.out.print(num + " ");
		}

	}

}