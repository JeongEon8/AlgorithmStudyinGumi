import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] list = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tmp = 0;
		while (st.hasMoreTokens()) {
			int m = Integer.parseInt(st.nextToken());
			list[tmp] = m;
			tmp++;
		}
		int large = 0;
		for (int i = 1; i < 9; i++) {
			for (int j = i + 1; j <= 9; j++) {
				int temp = 0;
				for (int k = 0; k < n; k++) {
					if (list[k] == i || list[k] == j) {
						temp++;
					} else {
						if (large < temp) {
							large = temp;
						}
						temp = 0;
					}
				}
				if (large < temp)
					large = temp;
			}
		}
		System.out.println(large);
	}
}
