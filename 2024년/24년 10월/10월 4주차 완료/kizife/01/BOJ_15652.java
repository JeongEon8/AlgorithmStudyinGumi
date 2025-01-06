import java.util.Scanner;

public class BOJ_15652 {

	static int n, m;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[m];

		dfs(1, 0);

	}

	private static void dfs(int start, int depth) {

		if (depth == m) {
			for (int i : arr) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}

		for (int i = start; i <= n; i++) {
			arr[depth] = i;
			dfs(i, depth + 1);
		}

	}

}
