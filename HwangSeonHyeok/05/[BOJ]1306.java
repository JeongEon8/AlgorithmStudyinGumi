import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[] arr;
	static int[] segTree;

	static int makeSeg(int index, int s, int e) {
		if (s == e) {
			segTree[index] = arr[s];
			return segTree[index];
		}
		int mid = (s + e) / 2;
		int left = makeSeg(index * 2, s, mid);
		int right = makeSeg(index * 2 + 1, mid + 1, e);
		segTree[index] = Math.max(left, right);
		return segTree[index];
	}

	static int querySeg(int index, int s, int e, int ts, int te) {
		if (ts <= s && e <= te) {
			return segTree[index];
		}
		if (s > te || e < ts) {
			return 0;
		}
		int mid = (s + e) / 2;
		int left = querySeg(index * 2, s, mid, ts, te);
		int right = querySeg(index * 2 + 1, mid + 1, e, ts, te);
		return Math.max(left, right);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] split = in.readLine().split(" ");
		int n = Integer.parseInt(split[0]);
		int m = Integer.parseInt(split[1]);
		arr = new int[n + 1];
		split = in.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i + 1] = Integer.parseInt(split[i]);
		}
		segTree = new int[n * 4];
		makeSeg(1, 1, n);

		int end = n - m + 1;
		StringBuffer sb = new StringBuffer();
		for (int i = m; i <= end; i++) {
			sb.append(querySeg(1, 1, n, i - m + 1, i + m - 1) + " ");
		}
		System.out.println(sb);

	}

}