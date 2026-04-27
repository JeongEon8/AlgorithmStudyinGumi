import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_9934 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer>[] tree = new ArrayList[K];
		int n = (int) Math.pow(2, K);
		int[] input = new int[n];
		for (int i = 1; i < n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < K; i++) {
			tree[i] = new ArrayList<Integer>();
		}

		solve(1, n, 0, K, input, tree);

		for (int i = 0; i < K; i++) {
			for (int node : tree[i]) {
				sb.append(node).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	public static void solve(int start, int end, int depth, int k, int[] arr, ArrayList<Integer>[] tree) {
		if (depth == k) {
			return;
		}

		int mid = (start + end) / 2;
		tree[depth].add(arr[mid]);
		solve(start, mid - 1, depth + 1, k, arr, tree);
		solve(mid + 1, end, depth + 1, k, arr, tree);
	}
}