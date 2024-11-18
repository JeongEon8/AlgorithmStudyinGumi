import java.util.*;
import java.io.*;

class Main {

	public static void main(String args[]) throws Exception {
		int[] queue = new int[100001];
		int fidx = 0;
		int ridx = 0;
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
				queue[ridx] = m;
				ridx++;
			} else if (word.equals("pop")) {
				if (ridx == fidx) {
					System.out.println(-1);
				} else {
					System.out.println(queue[fidx]);
					fidx++;
				}
			} else if (word.equals("size")) {
				System.out.println(ridx-fidx);
			} else if (word.equals("empty")) {
				if (ridx == fidx) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
			} else if (word.equals("front")) {
				if (ridx == fidx) {
					System.out.println(-1);
				} else {
					System.out.println(queue[fidx]);
				}
			} else if (word.equals("back")) {
				if (fidx == ridx) {
					System.out.println(-1);
				} else {
					System.out.println(queue[ridx-1]);
				}
			}
		}
	}
}
