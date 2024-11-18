import java.util.*;
import java.io.*;

class Main {

	public static void main(String args[]) throws Exception {
		int[] queue = new int[10001];
		int idx = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String word = st.nextToken();
			int m = 0;
			if (word.equals("push")) {
				m = Integer.parseInt(st.nextToken());
			}
			if (word.equals("push")) {
				queue[idx] = m;
				idx++;
			} else if (word.equals("pop")) {
				if (idx == 0) {
					System.out.println(-1);
				} else {
					idx--;
					System.out.println(queue[idx]);
				}
			} else if (word.equals("size")) {
				System.out.println(idx);
			} else if (word.equals("empty")) {
				if (idx == 0) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
			}else if (word.equals("top")) {
				if (idx == 0) {
					System.out.println(-1);
				} else {
					System.out.println(queue[idx - 1]);
				}
			}
		}
	}
}
